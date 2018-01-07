package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaFinder;
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
            executeRetrieve(new AliBabaFinder(connection));
            connection.close();
        } catch (Exception e) {
            throw new BenchmarkException(e);
        }
    }
}
