package cz.cvut.kbss.benchmark;

import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.model.Occurrence;
import cz.cvut.kbss.benchmark.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.Person;
import cz.cvut.kbss.benchmark.model.Resource;
import cz.cvut.kbss.benchmark.util.Constants;
import cz.cvut.kbss.benchmark.util.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cz.cvut.kbss.benchmark.util.Constants.ITEM_COUNT;
import static org.junit.Assert.*;

public abstract class AbstractRunner<P extends Person, R extends OccurrenceReport> {

    protected DataGenerator<P, R> generator;

    protected List<R> updated;
    protected List<R> deleted;

    protected void persistPersons(Saver<P, R> saver) {
        saver.begin();
        saver.persistAll(generator.getPersons());
        saver.commit();
    }

    protected void executeBatchCreate(Saver<P, R> saver) {
        saver.begin();
        generator.getReports().forEach(saver::persist);
        saver.commit();
    }

    protected void executeCreate(Saver<P, R> saver) {
        generator.getReports().forEach(r -> {
            saver.begin();
            saver.persist(r);
            saver.commit();
        });
    }

    protected void persistData(Saver<P, R> saver) {
        saver.begin();
        saver.persistAll(generator.getPersons());
        generator.getReports().forEach(saver::persist);
        saver.commit();
    }

    protected <O extends Occurrence, A extends Resource> void findAndVerifyAll(Finder<R> finder) {
        generator.getReports().forEach(r -> checkReport(r, finder.find(r)));
    }

    protected void checkReport(OccurrenceReport expected, OccurrenceReport actual) {
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
    }

    protected void executeUpdate(Updater<R> updater) {
        this.updated = new ArrayList<>(ITEM_COUNT / 2);
        for (int i = 0; i < generator.getReports().size(); i++) {
            if (i % 2 == 0) {
                continue;
            }
            final R toUpdate = generator.getReports().get(i);
            toUpdate.setLastModifiedBy(generator.randomItem(generator.getPersons()));
            toUpdate.getOccurrence().setName(toUpdate.getOccurrence().getName() + "-updated");
            toUpdate.setSeverityAssessment(i % Constants.MAX_SEVERITY);
            toUpdate.setLastModified(new Date(toUpdate.getLastModified().getTime() + 100000));
            toUpdate.setRevision(toUpdate.getRevision() + 1);
            toUpdate.getAttachments().add(generator.generateAttachment());
            updater.begin();
            updater.update(toUpdate);
            updater.commit();
            updated.add(toUpdate);
        }
    }

    protected <O extends Occurrence, A extends Resource> void verifyUpdates(Finder<R> finder) {
        updated.forEach(r -> {
            final R result = finder.find(r);
            checkReport(r, result);
        });
    }

    protected void executeDelete(Deleter<R> deleter) {
        this.deleted = new ArrayList<>(ITEM_COUNT / 2);
        for (int i = 0; i < generator.getReports().size(); i++) {
            if (i % 2 != 0) {
                continue;
            }
            final R toDelete = generator.getReports().get(i);
            deleter.begin();
            deleter.delete(toDelete);
            deleter.commit();
            deleted.add(toDelete);
        }
    }

    protected <O extends Occurrence, A extends Resource> void verifyDelete(Finder<R> finder) {
        deleted.forEach(r -> {
            assertFalse(finder.exists(r));
            assertFalse(finder.exists(r.getOccurrence()));
            r.getAttachments().forEach(a -> assertFalse(finder.exists((A) a)));
        });
    }
}
