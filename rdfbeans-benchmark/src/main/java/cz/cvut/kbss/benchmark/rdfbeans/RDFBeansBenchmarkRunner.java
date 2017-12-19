package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.BenchmarkRunner;
import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.util.AbstractBenchmarkUtil;
import cz.cvut.kbss.benchmark.util.Config;

public abstract class RDFBeansBenchmarkRunner implements BenchmarkRunner {

    PersistenceFactory persistenceFactory;
    DataGenerator generator;

    @Override
    public void setUpBeforeBenchmark() {
        this.generator = new RDFBeansDataGenerator();
        generator.generate();
    }

    @Override
    public void setUp() {
        this.persistenceFactory = new PersistenceFactory();
        BenchmarkRunner.super.setUp();
    }

    @Override
    public void tearDown() {
        persistenceFactory.close();
        Config.getRepoUrl().ifPresent(rUrl -> AbstractBenchmarkUtil.clearRepository(rUrl + "/statements"));
    }
}
