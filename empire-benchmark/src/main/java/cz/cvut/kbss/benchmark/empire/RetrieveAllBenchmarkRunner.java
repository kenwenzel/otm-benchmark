package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.util.EmpireFinder;

import javax.persistence.EntityManager;

public class RetrieveAllBenchmarkRunner extends RetrieveBenchmarkRunner {

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        executeRetrieveAll(new EmpireFinder(em));
    }
}
