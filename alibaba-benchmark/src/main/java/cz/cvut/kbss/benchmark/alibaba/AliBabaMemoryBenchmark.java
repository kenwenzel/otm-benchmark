package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.AbstractMemoryBenchmark;
import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.data.AlibabaDataGenerator;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.alibaba.model.Person;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaDeleter;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaFinder;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaSaver;
import cz.cvut.kbss.benchmark.alibaba.util.AliBabaUpdater;
import cz.cvut.kbss.benchmark.util.Deleter;
import cz.cvut.kbss.benchmark.util.Finder;
import cz.cvut.kbss.benchmark.util.Saver;
import cz.cvut.kbss.benchmark.util.Updater;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.config.RepositoryConfigException;

public class AliBabaMemoryBenchmark extends AbstractMemoryBenchmark<Person, OccurrenceReport> {

    private final PersistenceFactory persistenceFactory;

    private AliBabaMemoryBenchmark() {
        super(new AlibabaDataGenerator(0.01f));
        try {
            persistenceFactory = new PersistenceFactory();
        } catch (RepositoryException | RepositoryConfigException e) {
            throw new BenchmarkException(e);
        }
    }

    public static void main(String[] args) {
        // TODO
        new AliBabaMemoryBenchmark().execute();
    }

    @Override
    protected Saver<Person, OccurrenceReport> getSaver() {
        try {
            return new AliBabaSaver(persistenceFactory.objectConnection());
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    protected Finder<OccurrenceReport> getFinder() {
        try {
            return new AliBabaFinder(persistenceFactory.objectConnection());
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    protected Updater<OccurrenceReport> getUpdater() {
        try {
            return new AliBabaUpdater(persistenceFactory.objectConnection());
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    protected Deleter<OccurrenceReport> getDeleter() {
        try {
            return new AliBabaDeleter(persistenceFactory.objectConnection());
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }
}
