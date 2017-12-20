package cz.cvut.kbss.benchmark.komma;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.BenchmarkRunner;
import cz.cvut.kbss.benchmark.util.BenchmarkUtil;
import cz.cvut.kbss.benchmark.util.Config;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class KommaBenchmarkRunner implements BenchmarkRunner {

    static final Logger LOG = LoggerFactory.getLogger(KommaBenchmarkRunner.class);

    PersistenceFactory persistenceFactory;
    KommaGenerator generator;

    @Override
    public void setUpBeforeBenchmark() {
        this.generator = new KommaGenerator();
    }

    @Override
    public void setUp() {
        try {
            this.persistenceFactory = new PersistenceFactory();
        } catch (Exception e) {
            LOG.error("Unable to setup repository.", e);
            throw new BenchmarkException(e);
        }
        BenchmarkRunner.super.setUp();
    }

    @Override
    public void tearDown() {
        try {
            persistenceFactory.close();
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
        Config.getRepoUrl().ifPresent(rUrl -> BenchmarkUtil.clearRepository(rUrl + "/statements"));
    }
}
