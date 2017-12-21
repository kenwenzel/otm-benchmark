package cz.cvut.kbss.benchmark;

import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.Person;
import cz.cvut.kbss.benchmark.util.Constants;
import cz.cvut.kbss.benchmark.util.Saver;
import cz.cvut.kbss.benchmark.util.Updater;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public abstract class AbstractRunner<P extends Person, R extends OccurrenceReport> {

    protected DataGenerator<P, R> generator;

    protected List<R> updated;

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
        assertEquals(expected.getRevision(), actual.getRevision());
        assertEquals(expected.getLastModified(), actual.getLastModified());
        assertNotNull(actual.getOccurrence());
        assertEquals(expected.getOccurrence().getName(), actual.getOccurrence().getName());
        assertEquals(expected.getAttachments(), actual.getAttachments());
        assertEquals(expected.getAuthor(), actual.getAuthor());
        assertEquals(expected.getLastModifiedBy(), actual.getLastModifiedBy());
        assertEquals(expected.getAuthor().getContacts(), actual.getAuthor().getContacts());
        assertEquals(expected.getLastModifiedBy().getContacts(), actual.getLastModifiedBy().getContacts());
    }

    public void executeUpdate(Updater<R> updater) {
        this.updated = new ArrayList<>(Constants.ITEM_COUNT / 2);
        for (int i = 0; i < generator.getReports().size(); i++) {
            if (i % 2 == 0) {
                continue;
            }
            final R toUpdate = generator.getReports().get(i);
            toUpdate.setLastModifiedBy(generator.randomItem(generator.getPersons()));
            toUpdate.setLastModified(new Date(toUpdate.getLastModified().getTime() + 100000));
            toUpdate.setRevision(toUpdate.getRevision() + 1);
            toUpdate.getAuthor().getContacts().remove(toUpdate.getAuthor().getContacts().iterator().next());
            toUpdate.getAttachments().add(generator.generateAttachment());
            updater.begin();
            updater.update(toUpdate);
            updater.commit();
            updated.add(toUpdate);
        }
    }

    public void verifyUpdates(Function<R, R> finder) {
        updated.forEach(r -> {
            final R result = finder.apply(r);
            checkReport(r, result);
        });
    }
}
