package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.AbstractRunner;
import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.empire.data.EmpireDataGenerator;
import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.empire.model.Person;
import cz.cvut.kbss.benchmark.util.BenchmarkUtil;

import java.io.IOException;
import java.util.Properties;

import static cz.cvut.kbss.benchmark.empire.PersistenceFactory.CONFIG_FILE;

public abstract class EmpireBenchmarkRunner extends AbstractRunner<Person, OccurrenceReport> {

    private static final String SERVER_URL_PROPERTY = "0.url";
    private static final String REPO_NAME_PROPERTY = "0.repo";

    private static Properties properties;

    PersistenceFactory persistenceFactory;

    static {
        properties = new Properties();
        try {
            properties.load(EmpireBenchmarkRunner.class.getClassLoader().getResourceAsStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new BenchmarkException("Unable to load configuration file.");
        }
    }

    @Override
    protected DataGenerator<Person, OccurrenceReport> createGenerator(int factor) {
        return new EmpireDataGenerator(factor);
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
        if (properties.containsKey(SERVER_URL_PROPERTY)) {
            final String repoUrl = properties.getProperty(SERVER_URL_PROPERTY) + "repositories/" +
                    properties.getProperty(REPO_NAME_PROPERTY) + "/statements";
            BenchmarkUtil.clearRepository(repoUrl);
        }
    }
}
