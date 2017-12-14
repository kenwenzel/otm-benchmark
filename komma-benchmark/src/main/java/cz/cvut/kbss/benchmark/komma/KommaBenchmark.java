package cz.cvut.kbss.benchmark.komma;

import cz.cvut.kbss.benchmark.AbstractBenchmark;
import cz.cvut.kbss.benchmark.BenchmarkRunner;

public class KommaBenchmark extends AbstractBenchmark {

    public static void main(String[] args) {
        final KommaBenchmark benchmark = new KommaBenchmark();
        benchmark.run(args);
    }

    @Override
    protected BenchmarkRunner createBenchmarkRunner(String type) {
        switch (type) {
            case CREATE:
                return new CreateBenchmarkRunner();
            case RETRIEVE:
                return new RetrieveBenchmarkRunner();
            default:
                throw new IllegalArgumentException("Unsupported benchmark type " + type + ".");
        }
    }
}
