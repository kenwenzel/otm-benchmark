package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.jopa.util.JopaSaver;
import cz.cvut.kbss.jopa.model.EntityManager;

public class CreateBenchmarkRunner extends JopaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final EntityManager em = persistenceFactory.entityManager();
        persistPersons(new JopaSaver(em));
        em.close();
        System.gc();
        System.gc();
    }

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        findAndVerifyAll(r -> em.find(OccurrenceReport.class, r.getUri()));
        super.tearDown();
    }

    @Override
    public void execute() {
        // The entity manager will be closed in tearDown
        final EntityManager em = persistenceFactory.entityManager();
        executeCreate(new JopaSaver(em));
    }
}
