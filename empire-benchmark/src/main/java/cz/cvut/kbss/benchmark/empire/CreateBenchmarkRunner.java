package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.empire.util.EmpireSaver;

import javax.persistence.EntityManager;

public class CreateBenchmarkRunner extends EmpireBenchmarkRunner {

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        findAndVerifyAll(r -> em.find(OccurrenceReport.class, r.getRdfId()));
        super.tearDown();
    }

    @Override
    public void execute() {
        // The entity manager will be closed in tearDown
        final EntityManager em = persistenceFactory.entityManager();
//        em.getTransaction().begin();
        executeCreate(new EmpireSaver(em));
//        em.getTransaction().commit();
    }
}
