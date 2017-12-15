package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.util.BenchmarkUtil;
import org.openrdf.repository.object.ObjectConnection;

public class RetrieveBenchmarkRunner extends AlibabaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            BenchmarkUtil.persistAll(connection, generator.getReports());
        } catch (Exception e) {
            throw new BenchmarkException(e);
        }
        System.gc();
        System.gc();
    }

    @Override
    public void execute() {
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            BenchmarkUtil.retrieveAll(connection, generator.getReports());
        } catch (Exception e) {
            throw new BenchmarkException(e);
        }
    }
}
