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
            case RETRIEVE:
                return new RetrieveBenchmarkRunner();
            default:
                throw new IllegalArgumentException("Unsupported benchmark type " + type + '.');
        }
    }
}
