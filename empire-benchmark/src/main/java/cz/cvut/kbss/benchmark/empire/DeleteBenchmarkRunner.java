package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.util.EmpireDeleter;
import cz.cvut.kbss.benchmark.empire.util.EmpireFinder;
import cz.cvut.kbss.benchmark.empire.util.EmpireSaver;

import javax.persistence.EntityManager;

public class DeleteBenchmarkRunner extends EmpireBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final EntityManager em = persistenceFactory.entityManager();
        persistData(new EmpireSaver(em));
        em.clear();
        System.gc();
        System.gc();
        startMeasuringMemoryUsage();
    }

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        verifyDelete(new EmpireFinder(em));
        super.tearDown();
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        executeDelete(new EmpireDeleter(em));
    }
}
