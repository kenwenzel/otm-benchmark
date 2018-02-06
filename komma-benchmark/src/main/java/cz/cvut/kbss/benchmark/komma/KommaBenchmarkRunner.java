package cz.cvut.kbss.benchmark.komma;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.BenchmarkRunner;
import cz.cvut.kbss.benchmark.Configuration;
import cz.cvut.kbss.benchmark.util.BenchmarkUtil;
import cz.cvut.kbss.benchmark.util.Config;
import cz.cvut.kbss.benchmark.util.Constants;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

abstract class KommaBenchmarkRunner implements BenchmarkRunner {

    static final Logger LOG = LoggerFactory.getLogger(KommaBenchmarkRunner.class);

    private Configuration configuration;

    PersistenceFactory persistenceFactory;
    KommaGenerator generator;

    private Process memoryWatcher;

    @Override
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void setUpBeforeBenchmark() {
        this.generator = new KommaGenerator(configuration.getValue(Constants.FACTOR_PARAMETER, Integer.class));
    }

    @Override
    public void beforeFirstMeasured() {
        final String jstatOutput = configuration.getValue(Constants.MEMORY_PARAMETER, String.class);
        if (jstatOutput.isEmpty()) {
            return;
        }
        this.memoryWatcher = BenchmarkUtil.startJStat(new File(jstatOutput));
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
        if (memoryWatcher != null) {
            memoryWatcher.destroy();
            this.memoryWatcher = null;
        }
        try {
            persistenceFactory.close();
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
        Config.getRepoUrl().ifPresent(rUrl -> BenchmarkUtil.clearRepository(rUrl + "/statements"));
    }
}
