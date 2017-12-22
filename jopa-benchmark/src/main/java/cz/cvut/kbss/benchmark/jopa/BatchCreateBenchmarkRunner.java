package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.util.JopaSaver;

public class BatchCreateBenchmarkRunner extends CreateBenchmarkRunner {

    @Override
    public void execute() {
        executeBatchCreate(new JopaSaver(persistenceFactory.entityManager()));
    }
}
