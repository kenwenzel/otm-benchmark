package cz.cvut.kbss.benchmark;

import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.Person;
import cz.cvut.kbss.benchmark.util.Saver;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public abstract class AbstractRunner<P extends Person, R extends OccurrenceReport> {

    protected DataGenerator<P, R> generator;

    public void executeCreate(Saver<P, R> saver) {
        saver.begin();
        saver.persistAll(generator.getPersons());
        saver.commit();

        generator.getReports().forEach(r -> {
            saver.begin();
            saver.persist(r);
            saver.commit();
        });
    }

    public void persistData(Saver<P, R> saver) {
        saver.begin();
        saver.persistAll(generator.getPersons());
        generator.getReports().forEach(saver::persist);
        saver.commit();
    }

    public void findAndVerifyAll(Function<R, R> finder) {
        generator.getReports().forEach(r -> checkReport(r, finder.apply(r)));
    }

    protected void checkReport(OccurrenceReport expected, OccurrenceReport actual) {
        assertNotNull(actual);
        assertNotNull(actual.getAuthor());
        assertNotNull(actual.getLastModifiedBy());
        assertNotNull(actual.getOccurrence());
        assertEquals(expected.getOccurrence().getName(), actual.getOccurrence().getName());
        assertEquals(expected.getAttachments().size(), actual.getAttachments().size());
        assertEquals(expected.getAuthor().getContacts(), actual.getAuthor().getContacts());
        assertEquals(expected.getLastModifiedBy().getContacts(), actual.getLastModifiedBy().getContacts());
    }
}
