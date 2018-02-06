package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.AbstractRunner;
import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.jopa.data.JopaDataGenerator;
import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.jopa.model.Person;
import cz.cvut.kbss.benchmark.util.BenchmarkUtil;
import cz.cvut.kbss.benchmark.util.Config;

public abstract class JopaBenchmarkRunner extends AbstractRunner<Person, OccurrenceReport> {

    PersistenceFactory persistenceFactory;

    @Override
    protected DataGenerator<Person, OccurrenceReport> createGenerator(int factor) {
        return new JopaDataGenerator(factor);
    }

    @Override
    public void setUp() {
        this.persistenceFactory = new PersistenceFactory();
        super.setUp();
    }

    @Override
    public void tearDown() {
        super.tearDown();
        persistenceFactory.close();
        Config.getRepoUrl().ifPresent(rUrl -> BenchmarkUtil.clearRepository(rUrl + "/statements"));
    }
}
