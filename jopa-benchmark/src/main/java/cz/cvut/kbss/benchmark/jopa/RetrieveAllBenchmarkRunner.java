package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.util.JopaFinder;
import cz.cvut.kbss.jopa.model.EntityManager;

public class RetrieveAllBenchmarkRunner extends RetrieveBenchmarkRunner {

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        executeRetrieveAll(new JopaFinder(em));
    }
}
