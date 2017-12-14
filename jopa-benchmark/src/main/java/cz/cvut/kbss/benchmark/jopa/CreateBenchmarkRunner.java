package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.AbstractBenchmarkUtil;
import cz.cvut.kbss.jopa.model.EntityManager;

public class CreateBenchmarkRunner extends JopaBenchmarkRunner {

    @Override
    public void tearDown() {
        final EntityManager em = persistenceFactory.entityManager();
        AbstractBenchmarkUtil.findAndVerifyAll(generator, r -> em.find(OccurrenceReport.class, ((OccurrenceReport) r).getUri()));
        super.tearDown();
    }

    @Override
    public void execute() {
        // The entity manager will be closed in tearDown
        final EntityManager em = persistenceFactory.entityManager();
        em.getTransaction().begin();
        AbstractBenchmarkUtil.persistAll(generator, em::persist);
        em.getTransaction().commit();
    }
}
