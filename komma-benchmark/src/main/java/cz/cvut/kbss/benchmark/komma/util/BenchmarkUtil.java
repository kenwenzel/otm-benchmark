package cz.cvut.kbss.benchmark.komma.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.komma.KommaGenerator;
import cz.cvut.kbss.benchmark.komma.model.OccurrenceReport;
import net.enilink.komma.core.IEntityManager;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BenchmarkUtil {

    private static final DatatypeFactory FACTORY = initDatatypeFactory();

    private static DatatypeFactory initDatatypeFactory() {
        try {
            return DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new BenchmarkException("Unable to initialize Komma model.", e);
        }
    }

    public static DatatypeFactory datatypeFactory() {
        return FACTORY;
    }

    public static void findAllAndVerify(KommaGenerator generator, IEntityManager em) {
        generator.getReports().forEach(r -> {
            final OccurrenceReport result = em.find(generator.getUri(r), OccurrenceReport.class);
            assertNotNull(result);
            assertNotNull(result.getAuthor());
            assertNotNull(result.getLastModifiedBy());
            assertNotNull(result.getOccurrence());
            assertEquals(r.getAttachments().size(), result.getAttachments().size());
            assertEquals(r.getAuthor().getContacts(), result.getAuthor().getContacts());
            assertEquals(r.getLastModifiedBy().getContacts(), result.getLastModifiedBy().getContacts());
        });
    }
}
