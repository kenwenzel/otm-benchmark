package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
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
    }

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        verifyUpdates(r -> em.find(OccurrenceReport.class, r.getUri()));
        super.tearDown();
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        executeUpdate(new JopaUpdater(em));
    }
}
