package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.BenchmarkRunner;
import cz.cvut.kbss.benchmark.util.AbstractBenchmarkUtil;
import cz.cvut.kbss.benchmark.util.Config;
import org.openrdf.repository.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class AlibabaBenchmarkRunner implements BenchmarkRunner {

    static final Logger LOG = LoggerFactory.getLogger(CreateBenchmarkRunner.class);

    AlibabaDataGenerator generator;
    PersistenceFactory persistenceFactory;

    @Override
    public void setUpBeforeBenchmark() {
        this.generator = new AlibabaDataGenerator();
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
        Config.getRepoUrl().ifPresent(rUrl -> AbstractBenchmarkUtil.clearRepository(rUrl + "/statements"));
    }
}
