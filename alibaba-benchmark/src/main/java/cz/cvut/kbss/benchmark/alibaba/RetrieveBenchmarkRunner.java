package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import org.openrdf.repository.object.ObjectConnection;

public class RetrieveBenchmarkRunner extends AliBabaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        persistTestData();
        System.gc();
        System.gc();
    }

    @Override
    public void execute() {
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            findAndVerifyAll(report -> {
                try {
                    return connection.getObject(OccurrenceReport.class, report.getUri().toString());
                } catch (Exception e) {
                    throw new BenchmarkException(e);
                }
            });
            connection.close();
        } catch (Exception e) {
            throw new BenchmarkException(e);
        }
    }
}
