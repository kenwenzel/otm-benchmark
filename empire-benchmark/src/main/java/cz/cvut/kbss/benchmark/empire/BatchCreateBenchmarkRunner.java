package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.util.EmpireSaver;

import javax.persistence.EntityManager;

public class BatchCreateBenchmarkRunner extends CreateBenchmarkRunner {

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        executeBatchCreate(new EmpireSaver(em));
    }
}
