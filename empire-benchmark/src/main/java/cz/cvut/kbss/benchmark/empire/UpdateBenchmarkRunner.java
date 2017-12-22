package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.util.EmpireFinder;
import cz.cvut.kbss.benchmark.empire.util.EmpireSaver;
import cz.cvut.kbss.benchmark.empire.util.EmpireUpdater;

import javax.persistence.EntityManager;

public class UpdateBenchmarkRunner extends EmpireBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        generator.generate();
        final EntityManager em = persistenceFactory.entityManager();
        persistData(new EmpireSaver(em));
        em.clear();
        System.gc();
        System.gc();
    }

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        verifyUpdates(new EmpireFinder(em));
        super.tearDown();
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        executeUpdate(new EmpireUpdater(em));
    }
}
