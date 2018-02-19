package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.BenchmarkException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Config {

    //    private static final String CONFIG_FILE = "src/main/resources/config.properties";
    private static final String CONFIG_FILE = "config.properties";

    private static Properties configuration = new Properties();

    static {
        try {
            final InputStream is = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
            if (is == null) {
                throw new BenchmarkException("Benchmark configuration file is missing.");
            }
            configuration.load(is);
        } catch (IOException e) {
            throw new BenchmarkException("Unable to load configuration.", e);
        }
    }

    public static Optional<String> getRepoUrl() {
        final String url = configuration.getProperty("url", "");
        return url.isEmpty() ? Optional.empty() : Optional.of(url);
    }

    public static Optional<Long> getRuntime() {
        final String runtime = configuration.getProperty("memory.runtime", "");
        return runtime.isEmpty() ? Optional.empty() : Optional.of(Long.parseLong(runtime));
    }
}
