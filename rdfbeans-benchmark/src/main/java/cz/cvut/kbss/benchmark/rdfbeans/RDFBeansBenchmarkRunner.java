package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.AbstractRunner;
import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.rdfbeans.data.RDFBeansDataGenerator;
import cz.cvut.kbss.benchmark.rdfbeans.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.rdfbeans.model.Person;
import cz.cvut.kbss.benchmark.util.BenchmarkUtil;
import cz.cvut.kbss.benchmark.util.Config;

public abstract class RDFBeansBenchmarkRunner extends AbstractRunner<Person, OccurrenceReport> {

    PersistenceFactory persistenceFactory;

    @Override
    protected DataGenerator<Person, OccurrenceReport> createGenerator(int factor) {
        return new RDFBeansDataGenerator(factor);
    }

    @Override
    public void setUp() {
        this.persistenceFactory = new PersistenceFactory();
        super.setUp();
    }

    @Override
    public void tearDown() {
        persistenceFactory.close();
        Config.getRepoUrl().ifPresent(rUrl -> BenchmarkUtil.clearRepository(rUrl + "/statements"));
    }
}
