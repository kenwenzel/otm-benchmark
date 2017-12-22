package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaUpdater;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

public class UpdateBenchmarkRunner extends AliBabaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        generator.generate();
        persistTestData();
        System.gc();
        System.gc();
    }

    @Override
    public void tearDown() {
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            verifyUpdates(r -> {
                try {
                    return connection.getObject(OccurrenceReport.class, r.getUri().toString());
                } catch (RepositoryException | QueryEvaluationException e) {
                    throw new BenchmarkException(e);
                }
            });
            connection.close();
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
        super.tearDown();
    }

    @Override
    public void execute() {
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            executeUpdate(new AliBabaUpdater(connection));
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }
}