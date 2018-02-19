package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.AbstractMemoryBenchmark;
import cz.cvut.kbss.benchmark.rdfbeans.data.RDFBeansDataGenerator;
import cz.cvut.kbss.benchmark.rdfbeans.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.rdfbeans.model.Person;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansDeleter;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansFinder;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansSaver;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansUpdater;
import cz.cvut.kbss.benchmark.util.Deleter;
import cz.cvut.kbss.benchmark.util.Finder;
import cz.cvut.kbss.benchmark.util.Saver;
import cz.cvut.kbss.benchmark.util.Updater;

public class RdfBeansMemoryBenchmark extends AbstractMemoryBenchmark<Person, OccurrenceReport> {

    private final PersistenceFactory persistenceFactory;

    private RdfBeansMemoryBenchmark() {
        super(new RDFBeansDataGenerator(0.1f));
        persistenceFactory = new PersistenceFactory();
    }

    public static void main(String[] args) {
        new RdfBeansMemoryBenchmark().execute();
    }

    @Override
    protected Saver<Person, OccurrenceReport> getSaver() {
        return new RdfBeansSaver(persistenceFactory.beanManager());
    }

    @Override
    protected Finder<OccurrenceReport> getFinder() {
        return new RdfBeansFinder(persistenceFactory.beanManager());
    }

    @Override
    protected Updater<OccurrenceReport> getUpdater() {
        return new RdfBeansUpdater(persistenceFactory.beanManager());
    }

    @Override
    protected Deleter<OccurrenceReport> getDeleter() {
        return new RdfBeansDeleter(persistenceFactory.beanManager());
    }
}
