package cz.cvut.kbss.benchmark.komma;

import cz.cvut.kbss.benchmark.komma.util.BenchmarkUtil;
import net.enilink.komma.core.IEntityManager;

public class CreateBenchmarkRunner extends KommaBenchmarkRunner {

    @Override
    public void tearDown() {
        final IEntityManager em = persistenceFactory.entityManager();
        BenchmarkUtil.findAllAndVerify(generator, em);
        super.tearDown();
    }

    @Override
    public void execute() {
        final IEntityManager em = persistenceFactory.entityManager();
        em.getTransaction().begin();
        generator.setEm(em);
        generator.generate();
        em.getTransaction().commit();
    }
}