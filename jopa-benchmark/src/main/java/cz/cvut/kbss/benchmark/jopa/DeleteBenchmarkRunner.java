package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.util.JopaDeleter;
import cz.cvut.kbss.benchmark.jopa.util.JopaFinder;
import cz.cvut.kbss.benchmark.jopa.util.JopaSaver;
import cz.cvut.kbss.jopa.model.EntityManager;

public class DeleteBenchmarkRunner extends JopaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final EntityManager em = persistenceFactory.entityManager();
        persistData(new JopaSaver(em));
        em.close();
        System.gc();
        System.gc();
        startMeasuringMemoryUsage();
    }

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        verifyDelete(new JopaFinder(em));
        super.tearDown();
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        executeDelete(new JopaDeleter(em));
    }
}
