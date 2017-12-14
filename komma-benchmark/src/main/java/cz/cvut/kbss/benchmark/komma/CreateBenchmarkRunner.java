package cz.cvut.kbss.benchmark.komma;

import net.enilink.komma.core.IEntityManager;

public class CreateBenchmarkRunner extends KommaBenchmarkRunner {

    @Override
    public void tearDown() {
        // Verify data
        super.tearDown();
    }

    @Override
    public void execute() {
        final IEntityManager em = persistenceFactory.entityManager();
        em.getTransaction().begin();

        em.getTransaction().commit();
    }
}
