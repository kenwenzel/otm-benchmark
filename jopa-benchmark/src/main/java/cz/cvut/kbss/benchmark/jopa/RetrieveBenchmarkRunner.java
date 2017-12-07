package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.util.BenchmarkUtil;
import cz.cvut.kbss.jopa.model.EntityManager;

public class RetrieveBenchmarkRunner extends JopaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final EntityManager em = persistenceFactory.entityManager();
        em.getTransaction().begin();
        BenchmarkUtil.persistAll(em, generator.getReports());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        BenchmarkUtil.retrieveAll(em, generator.getReports());
    }
}
