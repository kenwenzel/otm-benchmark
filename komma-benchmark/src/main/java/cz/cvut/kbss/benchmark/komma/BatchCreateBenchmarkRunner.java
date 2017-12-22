package cz.cvut.kbss.benchmark.komma;

import net.enilink.komma.core.IEntityManager;

public class BatchCreateBenchmarkRunner extends CreateBenchmarkRunner {

    @Override
    public void execute() {
        final IEntityManager em = persistenceFactory.entityManager();
        generator.setEm(em);
        generator.executeBatchCreate();
    }
}
