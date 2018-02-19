package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class BenchmarkUtil {

    private static final Logger LOG = LoggerFactory.getLogger(BenchmarkUtil.class);

    private static final Timer TIMER = new Timer();

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

    public static Process startJStat(File outputFile) {
        final String mxName = ManagementFactory.getRuntimeMXBean().getName();
        final String pid = mxName.substring(0, mxName.indexOf('@'));
        try {
            if (!outputFile.exists()) {
                final boolean result = outputFile.createNewFile();
                if (!result) {
                    throw new BenchmarkException("Unable to create jstat output file.");
                }
            }
            final ProcessBuilder pb = new ProcessBuilder("jstat", "-gc", pid, "250");
            pb.redirectErrorStream(true);
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(outputFile));
            return pb.start();
        } catch (IOException e) {
            throw new BenchmarkException("Unable to start jstat.", e);
        }
    }

    /**
     * Configures the application to shutdown after the specified delay.
     *
     * @param delay Delay in milliseconds
     */
    public static void scheduleApplicationShutdown(long delay) {
        LOG.info("Scheduling application shutdown in {} ms.", delay);
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                LOG.info("Shutting the application down.");
                System.exit(0);
            }
        };
        TIMER.schedule(task, delay);
    }
}
