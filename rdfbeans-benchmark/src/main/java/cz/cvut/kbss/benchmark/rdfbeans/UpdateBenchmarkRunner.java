package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansFinder;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansSaver;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansUpdater;
import org.cyberborean.rdfbeans.RDFBeanManager;

public class UpdateBenchmarkRunner extends RDFBeansBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        generator.generate();
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        persistData(new RdfBeansSaver(beanManager));
        System.gc();
        System.gc();
        startMeasuringMemoryUsage();
    }

    @Override
    public void tearDown() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        verifyUpdates(new RdfBeansFinder(beanManager));
        super.tearDown();
    }

    @Override
    public void execute() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        executeUpdate(new RdfBeansUpdater(beanManager));
    }
}
