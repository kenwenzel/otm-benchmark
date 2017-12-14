package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.AbstractBenchmarkUtil;

import javax.persistence.EntityManager;

public class CreateBenchmarkRunner extends EmpireBenchmarkRunner {

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        AbstractBenchmarkUtil
                .findAndVerifyAll(generator, r -> em.find(OccurrenceReport.class, ((OccurrenceReport) r).getRdfId()));
        super.tearDown();
    }

    @Override
    public void execute() {
        // The entity manager will be closed in tearDown
        final EntityManager em = persistenceFactory.entityManager();
//        em.getTransaction().begin();
        AbstractBenchmarkUtil.persistAll(generator, em::persist);
//        em.getTransaction().commit();
    }
}
