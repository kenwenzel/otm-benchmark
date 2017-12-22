package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.AbstractBenchmark;
import cz.cvut.kbss.benchmark.BenchmarkRunner;

public class AliBabaBenchmark extends AbstractBenchmark {

    public static void main(String[] args) {
        final AliBabaBenchmark benchmark = new AliBabaBenchmark();
        benchmark.run(args);
    }

    protected BenchmarkRunner createBenchmarkRunner(String type) {
        switch (type) {
            case CREATE:
                return new CreateBenchmarkRunner();
            case BATCH_CREATE:
                return new BatchCreateBenchmarkRunner();
            case RETRIEVE:
                return new RetrieveBenchmarkRunner();
            case UPDATE:
                return new UpdateBenchmarkRunner();
            case DELETE:
                return new DeleteBenchmarkRunner();
            default:
                throw new IllegalArgumentException("Unsupported benchmark type " + type + '.');
        }
    }
}
