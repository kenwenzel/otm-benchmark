package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.BenchmarkRunner;
import cz.cvut.kbss.benchmark.util.AbstractBenchmarkUtil;
import cz.cvut.kbss.benchmark.util.Config;

public abstract class JopaBenchmarkRunner extends BenchmarkRunner {

    PersistenceFactory persistenceFactory;
    JopaDataGenerator generator;

    @Override
    public void setUpBeforeBenchmark() {
        this.generator = new JopaDataGenerator();
    }

    @Override
    public void setUp() {
        this.persistenceFactory = new PersistenceFactory();
        super.setUp();
    }

    @Override
    public void tearDown() {
        persistenceFactory.close();
        Config.getRepoUrl().ifPresent(rUrl -> AbstractBenchmarkUtil.clearRepository(rUrl + "/statements"));
    }
}
