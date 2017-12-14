package cz.cvut.kbss.benchmark.komma;

import cz.cvut.kbss.benchmark.komma.util.BenchmarkUtil;
import net.enilink.komma.core.IEntityManager;

public class RetrieveBenchmarkRunner extends KommaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final IEntityManager em = persistenceFactory.entityManager();
        em.getTransaction().begin();
        generator.setEm(em);
        generator.generate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void execute() {
        final IEntityManager em = persistenceFactory.entityManager();
        BenchmarkUtil.findAllAndVerify(generator, em);
    }
}
