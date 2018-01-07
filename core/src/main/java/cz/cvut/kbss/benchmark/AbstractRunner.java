package cz.cvut.kbss.benchmark;

import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.model.*;
import cz.cvut.kbss.benchmark.util.Constants;
import cz.cvut.kbss.benchmark.util.*;

import java.util.*;

import static cz.cvut.kbss.benchmark.util.Constants.ITEM_COUNT;
import static org.junit.Assert.*;

public abstract class AbstractRunner<P extends Person, R extends OccurrenceReport> implements BenchmarkRunner {

    protected DataGenerator<P, R> generator;

    protected List<R> updated;
    protected List<R> deleted;

    protected Configuration configuration;

    @Override
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void setUpBeforeBenchmark() {
        this.generator = createGenerator(configuration.getValue(Constants.FACTOR_PARAMETER, Integer.class));
    }

    /**
     * Creates the data generator.
     * <p>
     * This is called before the benchmark.
     *
     * @param factor Scaling factor used for data generator initialization
     */
    protected abstract DataGenerator<P, R> createGenerator(int factor);

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

    protected void executeRetrieve(Finder<R> finder) {
        findAndVerifyAll(finder);
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
        checkEvents(expected.getOccurrence().getSubEvents(), actual.getOccurrence().getSubEvents());
    }

    protected void checkEvents(Set<Event> expected, Set<Event> actual) {
        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        for (Event expEvent : expected) {
            final Optional<Event> actEvent = actual.stream().filter(e -> expEvent.getId().equals(e.getId())).findAny();
            assertTrue(actEvent.isPresent());
            final Event evt = actEvent.get();
            assertEquals(expEvent.getStartTime(), evt.getStartTime());
            assertEquals(expEvent.getEndTime(), evt.getEndTime());
            assertEquals(expEvent.getEventType(), evt.getEventType());
            if (expEvent.getSubEvents() != null) {
                checkEvents(expEvent.getSubEvents(), evt.getSubEvents());
            }
        }
    }

    protected void executeRetrieveAll(Finder<R> finder) {
        final Collection<R> result = finder.findAll();
        assertEquals(generator.getReports().size(), result.size());
        for (R report : generator.getReports()) {
            boolean found = false;
            for (R resultReport : result) {
                if (report.getId().equals(resultReport.getId())) {
                    found = true;
                    checkReport(report, resultReport);
                    break;
                }
            }
            assertTrue(found);
        }
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
            verifyDeletedEvents(r.getOccurrence().getSubEvents(), finder);
        });
    }

    private void verifyDeletedEvents(Set<Event> events, Finder<R> finder) {
        if (events == null) {
            return;
        }
        events.forEach(e -> {
            assertFalse(finder.exists(e));
            verifyDeletedEvents(e.getSubEvents(), finder);
        });
    }
}
