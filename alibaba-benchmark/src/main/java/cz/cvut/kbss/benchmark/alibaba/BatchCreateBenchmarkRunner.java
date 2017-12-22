package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaSaver;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

public class BatchCreateBenchmarkRunner extends CreateBenchmarkRunner {

    @Override
    public void execute() {
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            executeBatchCreate(new AliBabaSaver(connection));
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }
}
