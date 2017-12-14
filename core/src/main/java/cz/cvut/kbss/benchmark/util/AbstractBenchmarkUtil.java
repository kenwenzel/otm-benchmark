package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.model.OccurrenceReport;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.Assert.assertNotNull;

public class AbstractBenchmarkUtil {

    private AbstractBenchmarkUtil() {
        throw new AssertionError();
    }

    public static void persistAll(DataGenerator data, Consumer<Object> persist) {
        data.getPersons().forEach(persist::accept);
        data.getReports().forEach(persist::accept);
    }

    public static void findAndVerifyAll(DataGenerator data, Function<OccurrenceReport, OccurrenceReport> finder) {
        data.getReports().forEach(r -> checkReport(finder.apply(r)));
    }

    public static void checkReport(OccurrenceReport report) {
        assertNotNull(report);
        assertNotNull(report.getAuthor());
        assertNotNull(report.getLastModifiedBy());
        assertNotNull(report.getOccurrence());
    }

    public static void clearRepository(String repoUrl) {
        try {
            final URL url = new URL(repoUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            final int responseCode = conn.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                throw new BenchmarkException(
                        "Unable to clear the benchmark repository. Received response code " + responseCode);
            }
            conn.disconnect();
        } catch (java.io.IOException e) {
            throw new BenchmarkException("Unable to connect to the benchmark repo.");
        }
    }
}
