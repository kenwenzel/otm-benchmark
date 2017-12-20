package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.BenchmarkException;

import java.net.HttpURLConnection;
import java.net.URL;

public class BenchmarkUtil {

    private BenchmarkUtil() {
        throw new AssertionError();
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
