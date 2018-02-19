package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.AbstractMemoryBenchmark;
import cz.cvut.kbss.benchmark.jopa.data.JopaDataGenerator;
import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.jopa.model.Person;
import cz.cvut.kbss.benchmark.jopa.util.JopaDeleter;
import cz.cvut.kbss.benchmark.jopa.util.JopaFinder;
import cz.cvut.kbss.benchmark.jopa.util.JopaSaver;
import cz.cvut.kbss.benchmark.jopa.util.JopaUpdater;
import cz.cvut.kbss.benchmark.util.Deleter;
import cz.cvut.kbss.benchmark.util.Finder;
import cz.cvut.kbss.benchmark.util.Saver;
import cz.cvut.kbss.benchmark.util.Updater;

public class JopaMemoryBenchmark extends AbstractMemoryBenchmark<Person, OccurrenceReport> {

    private final PersistenceFactory persistenceFactory;

    private JopaMemoryBenchmark() {
        super(new JopaDataGenerator(1));
        persistenceFactory = new PersistenceFactory();
    }

    public static void main(String[] args) {
        new JopaMemoryBenchmark().execute();
    }

    @Override
    protected Saver<Person, OccurrenceReport> getSaver() {
        return new JopaSaver(persistenceFactory.entityManager());
    }

    @Override
    protected Finder<OccurrenceReport> getFinder() {
        return new JopaFinder(persistenceFactory.entityManager());
    }

    @Override
    protected Updater<OccurrenceReport> getUpdater() {
        return new JopaUpdater(persistenceFactory.entityManager());
    }

    @Override
    protected Deleter<OccurrenceReport> getDeleter() {
        return new JopaDeleter(persistenceFactory.entityManager());
    }
}
