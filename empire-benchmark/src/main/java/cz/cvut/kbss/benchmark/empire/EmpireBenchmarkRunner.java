package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.BenchmarkRunner;
import cz.cvut.kbss.benchmark.util.AbstractBenchmarkUtil;

import java.io.IOException;
import java.util.Properties;

import static cz.cvut.kbss.benchmark.empire.PersistenceFactory.CONFIG_FILE;

public abstract class EmpireBenchmarkRunner extends BenchmarkRunner {

    private static final String SERVER_URL_PROPERTY = "0.url";
    private static final String REPO_NAME_PROPERTY = "0.repo";

    private static Properties properties;

    PersistenceFactory persistenceFactory;
    EmpireDataGenerator generator;

    static {
        properties = new Properties();
        try {
            properties.load(EmpireBenchmarkRunner.class.getClassLoader().getResourceAsStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new BenchmarkException("Unable to load configuration file.");
        }
    }

    @Override
    public void setUpBeforeBenchmark() {
        this.generator = new EmpireDataGenerator();
    }

    @Override
    public void setUp() {
        this.persistenceFactory = new PersistenceFactory();
    }

    @Override
    public void tearDown() {
        persistenceFactory.close();
        if (properties.containsKey(SERVER_URL_PROPERTY)) {
            final String repoUrl = properties.getProperty(SERVER_URL_PROPERTY) + "repositories/" +
                    properties.getProperty(REPO_NAME_PROPERTY) + "/statements";
            AbstractBenchmarkUtil.clearRepository(repoUrl);
        }
    }
}
