package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaDeleter;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaFinder;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

public class DeleteBenchmarkRunner extends AliBabaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        persistTestData();
        System.gc();
        System.gc();
    }

    @Override
    public void tearDown() {
        try {
            verifyDelete(new AliBabaFinder(persistenceFactory.objectConnection()));
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
        super.tearDown();
    }

    @Override
    public void execute() {
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            executeDelete(new AliBabaDeleter(connection));
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }
}
