package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.util.BenchmarkUtil;

import javax.persistence.EntityManager;

public class RetrieveBenchmarkRunner extends EmpireBenchmarkRunner {


    @Override
    public void setUp() {
        super.setUp();
        final EntityManager em = persistenceFactory.entityManager();
//        em.getTransaction().begin();
        BenchmarkUtil.persistAll(em, generator.getReports());
//        em.getTransaction().commit(); // Empire executes each persist in a transaction. A global transaction is of no use
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        BenchmarkUtil.readAll(em, generator.getReports());
    }
}
