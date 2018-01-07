package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaFinder;
import org.openrdf.repository.object.ObjectConnection;

public class RetrieveAllBenchmarkRunner extends RetrieveBenchmarkRunner {

    @Override
    public void execute() {
        try {
            final ObjectConnection connection = persistenceFactory.objectConnection();
            executeRetrieveAll(new AliBabaFinder(connection));
            connection.close();
        } catch (Exception e) {
            throw new BenchmarkException(e);
        }
    }
}
