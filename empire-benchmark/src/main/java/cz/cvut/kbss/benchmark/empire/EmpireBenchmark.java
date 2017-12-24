package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.AbstractBenchmark;
import cz.cvut.kbss.benchmark.BenchmarkRunner;

public class EmpireBenchmark extends AbstractBenchmark {

    public static void main(String[] args) {
        final EmpireBenchmark benchmark = new EmpireBenchmark();
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
