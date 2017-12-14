package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.AbstractBenchmarkUtil;
import cz.cvut.kbss.jopa.model.EntityManager;

public class RetrieveBenchmarkRunner extends JopaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final EntityManager em = persistenceFactory.entityManager();
        em.getTransaction().begin();
        AbstractBenchmarkUtil.persistAll(generator, em::persist);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        AbstractBenchmarkUtil.findAndVerifyAll(generator, r -> em.find(OccurrenceReport.class, ((OccurrenceReport) r).getUri()));
    }
}
