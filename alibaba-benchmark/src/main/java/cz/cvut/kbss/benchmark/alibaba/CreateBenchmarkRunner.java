package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaFinder;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaSaver;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

public class CreateBenchmarkRunner extends AliBabaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            persistPersons(new AliBabaSaver(connection));
            connection.close();
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
        System.gc();
        System.gc();
        startMeasuringMemoryUsage();
    }

    @Override
    public void tearDown() {
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            findAndVerifyAll(new AliBabaFinder(connection));
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
            executeCreate(new AliBabaSaver(connection));
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }
}
