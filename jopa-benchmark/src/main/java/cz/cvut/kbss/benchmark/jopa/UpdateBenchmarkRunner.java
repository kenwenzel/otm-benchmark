package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.util.JopaFinder;
import cz.cvut.kbss.benchmark.jopa.util.JopaSaver;
import cz.cvut.kbss.benchmark.jopa.util.JopaUpdater;
import cz.cvut.kbss.jopa.model.EntityManager;

public class UpdateBenchmarkRunner extends JopaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        generator.generate();   // Regenerate data before each round
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
        verifyUpdates(new JopaFinder(em));
        super.tearDown();
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        executeUpdate(new JopaUpdater(em));
    }
}
