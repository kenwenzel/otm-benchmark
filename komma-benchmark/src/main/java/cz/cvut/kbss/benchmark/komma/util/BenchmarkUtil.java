package cz.cvut.kbss.benchmark.komma.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.komma.KommaGenerator;
import cz.cvut.kbss.benchmark.komma.model.Event;
import cz.cvut.kbss.benchmark.komma.model.OccurrenceReport;
import net.enilink.komma.core.IEntityManager;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

public class BenchmarkUtil {

    private static final DatatypeFactory FACTORY = initDatatypeFactory();

    private static DatatypeFactory initDatatypeFactory() {
        try {
            return DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new BenchmarkException("Unable to initialize KOMMA model.", e);
        }
    }

    public static DatatypeFactory datatypeFactory() {
        return FACTORY;
    }

    public static void findAllAndVerify(KommaGenerator generator, IEntityManager em) {
        generator.getReports().forEach(r -> {
            final OccurrenceReport result = em.find(generator.getUri(r), OccurrenceReport.class);
            checkReport(r, result);
        });
    }

    public static void checkReport(OccurrenceReport expected, OccurrenceReport actual) {
        assertNotNull(actual);
        assertEquals(expected.getRevision(), actual.getRevision());
        assertEquals(expected.getLastModified(), actual.getLastModified());
        assertNotNull(actual.getOccurrence());
        assertEquals(expected.getOccurrence().getName(), actual.getOccurrence().getName());
        assertEquals(expected.getSeverityAssessment(), actual.getSeverityAssessment());
        assertEquals(expected.getAttachments(), actual.getAttachments());
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getLastModifiedBy(), actual.getLastModifiedBy());
        assertEquals(expected.getAuthor().getContacts(), actual.getAuthor().getContacts());
        assertEquals(expected.getLastModifiedBy().getContacts(), actual.getLastModifiedBy().getContacts());
        checkEvents(expected.getOccurrence().getSubEvents(), actual.getOccurrence().getSubEvents());
    }

    protected static void checkEvents(Set<Event> expected, Set<Event> actual) {
        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        for (Event expEvent : expected) {
            final Optional<Event> actEvent = actual.stream().filter(e -> expEvent.getKey().equals(e.getKey())).findAny();
            assertTrue(actEvent.isPresent());
            final Event evt = actEvent.get();
            assertEquals(expEvent.getStart(), evt.getStart());
            assertEquals(expEvent.getEnd(), evt.getEnd());
            assertEquals(expEvent.getEventType(), evt.getEventType());
            if (expEvent.getSubEvents() != null) {
                checkEvents(expEvent.getSubEvents(), evt.getSubEvents());
            }
        }
    }

    public static XMLGregorianCalendar toXmlGregorianCalendar(Date date) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        return datatypeFactory().newXMLGregorianCalendar(c);
    }
}
