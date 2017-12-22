package cz.cvut.kbss.benchmark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBenchmark {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractBenchmark.class);

    protected static final String CREATE = "create";
    protected static final String BATCH_CREATE = "create-batch";
    protected static final String RETRIEVE = "retrieve";
    protected static final String UPDATE = "update";
    protected static final String DELETE = "delete";

    protected void run(String[] args) {
        if (args.length < 1) {
            printHelp();
        }
        final String type = args[args.length - 1];
        BenchmarkRunner runner = null;
        try {
            runner = createBenchmarkRunner(type);
        } catch (IllegalArgumentException e) {
            LOG.error("Unable to create benchmark runner.", e);
            printHelp();
            System.exit(1);
        }

        final Benchmark benchmark = new Benchmark(runner, args);
        benchmark.execute();
    }

    protected abstract BenchmarkRunner createBenchmarkRunner(String type);

    private static void printHelp() {
        System.out.println("Usage:");
        System.out.println("[execution-configuration] (" + CREATE + '|' + RETRIEVE + '|' + UPDATE + '|' + DELETE + ')');
        System.out.println("execution-configuration: ");
        Configuration.printHelp();
    }
}
