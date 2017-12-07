package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.BenchmarkException;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class Config {

    //    private static final String CONFIG_FILE = "src/main/resources/config.properties";
    private static final String CONFIG_FILE = "config.properties";

    private static Properties configuration = new Properties();

    static {
        try {
            configuration.load(Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new BenchmarkException("Unable to load configuration.", e);
        }
    }

    public static Optional<String> getRepoUrl() {
        final String url = configuration.getProperty("url", "");
        return url.isEmpty() ? Optional.empty() : Optional.of(url);
    }
}
