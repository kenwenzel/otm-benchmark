package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.BenchmarkRunner;
import cz.cvut.kbss.benchmark.jopa.data.JopaDataGenerator;
import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.jopa.model.Person;
import cz.cvut.kbss.benchmark.util.BenchmarkUtil;
import cz.cvut.kbss.benchmark.AbstractRunner;
import cz.cvut.kbss.benchmark.util.Config;

public abstract class JopaBenchmarkRunner extends AbstractRunner<Person, OccurrenceReport> implements BenchmarkRunner {

    PersistenceFactory persistenceFactory;

    @Override
    public void setUpBeforeBenchmark() {
        this.generator = new JopaDataGenerator();
    }

    @Override
    public void setUp() {
        this.persistenceFactory = new PersistenceFactory();
        BenchmarkRunner.super.setUp();
    }

    @Override
    public void tearDown() {
        persistenceFactory.close();
        Config.getRepoUrl().ifPresent(rUrl -> BenchmarkUtil.clearRepository(rUrl + "/statements"));
    }
}
