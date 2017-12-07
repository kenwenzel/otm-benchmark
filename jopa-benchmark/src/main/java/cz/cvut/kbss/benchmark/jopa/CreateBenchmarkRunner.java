package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.util.BenchmarkUtil;
import cz.cvut.kbss.jopa.model.EntityManager;

public class CreateBenchmarkRunner extends JopaBenchmarkRunner {

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        BenchmarkUtil.retrieveAll(em, generator.getReports());
        super.tearDown();
    }

    @Override
    public void execute() {
        // The entity manager will be closed in tearDown
        final EntityManager em = persistenceFactory.entityManager();
        em.getTransaction().begin();
        BenchmarkUtil.persistAll(em, generator.getReports());
        em.getTransaction().commit();
    }
}
