package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.empire.util.EmpireSaver;

import javax.persistence.EntityManager;

public class RetrieveBenchmarkRunner extends EmpireBenchmarkRunner {


    @Override
    public void setUp() {
        super.setUp();
        final EntityManager em = persistenceFactory.entityManager();
//        em.getTransaction().begin();
        persistData(new EmpireSaver(em));
//        em.getTransaction().commit(); // Empire executes each persist in a transaction. A global transaction is of no use
        em.clear();
        System.gc();
        System.gc();
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        findAndVerifyAll(r -> em.find(OccurrenceReport.class, r.getRdfId()));
    }
}
