package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.util.EmpireFinder;
import cz.cvut.kbss.benchmark.empire.util.EmpireSaver;

import javax.persistence.EntityManager;

public class CreateBenchmarkRunner extends EmpireBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final EntityManager em = persistenceFactory.entityManager();
        persistPersons(new EmpireSaver(em));
        startMeasuringMemoryUsage();
    }

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        findAndVerifyAll(new EmpireFinder(em));
        super.tearDown();
    }

    @Override
    public void execute() {
        // The entity manager will be closed in tearDown
        final EntityManager em = persistenceFactory.entityManager();
        executeCreate(new EmpireSaver(em));
    }
}
