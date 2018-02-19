package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.AbstractMemoryBenchmark;
import cz.cvut.kbss.benchmark.empire.data.EmpireDataGenerator;
import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.empire.model.Person;
import cz.cvut.kbss.benchmark.empire.util.EmpireDeleter;
import cz.cvut.kbss.benchmark.empire.util.EmpireFinder;
import cz.cvut.kbss.benchmark.empire.util.EmpireSaver;
import cz.cvut.kbss.benchmark.empire.util.EmpireUpdater;
import cz.cvut.kbss.benchmark.util.Deleter;
import cz.cvut.kbss.benchmark.util.Finder;
import cz.cvut.kbss.benchmark.util.Saver;
import cz.cvut.kbss.benchmark.util.Updater;

public class EmpireMemoryBenchmark extends AbstractMemoryBenchmark<Person, OccurrenceReport> {

    private final PersistenceFactory persistenceFactory;

    private EmpireMemoryBenchmark() {
        super(new EmpireDataGenerator(1));
        this.persistenceFactory = new PersistenceFactory();
    }

    public static void main(String[] args) {
        new EmpireMemoryBenchmark().execute();
    }

    @Override
    protected Saver<Person, OccurrenceReport> getSaver() {
        return new EmpireSaver(persistenceFactory.entityManager());
    }

    @Override
    protected Finder<OccurrenceReport> getFinder() {
        return new EmpireFinder(persistenceFactory.entityManager());
    }

    @Override
    protected Updater<OccurrenceReport> getUpdater() {
        return new EmpireUpdater(persistenceFactory.entityManager());
    }

    @Override
    protected Deleter<OccurrenceReport> getDeleter() {
        return new EmpireDeleter(persistenceFactory.entityManager());
    }
}
