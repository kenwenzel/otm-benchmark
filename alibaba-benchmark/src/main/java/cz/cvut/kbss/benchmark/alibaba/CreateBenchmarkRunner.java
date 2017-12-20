package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaSaver;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

public class CreateBenchmarkRunner extends AlibabaBenchmarkRunner {

    @Override
    public void tearDown() {
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            findAndVerifyAll(report -> {
                try {
                    return connection
                            .getObject(OccurrenceReport.class, report.getUri().toString());
                } catch (Exception e) {
                    throw new BenchmarkException(e);
                }
            });
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
        super.tearDown();
    }

    @Override
    public void execute() {
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            final AliBabaSaver saver = new AliBabaSaver(connection);
            executeCreate(saver);
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }
}
