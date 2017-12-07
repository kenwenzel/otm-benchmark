package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.util.BenchmarkUtil;

import javax.persistence.EntityManager;

public class CreateBenchmarkRunner extends EmpireBenchmarkRunner {

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        BenchmarkUtil.readAll(em, generator.getReports());
        super.tearDown();
    }

    @Override
    public void execute() {
        // The entity manager will be closed in tearDown
        final EntityManager em = persistenceFactory.entityManager();
//        em.getTransaction().begin();
        BenchmarkUtil.persistAll(em, generator.getReports());
//        em.getTransaction().commit();
    }
}
