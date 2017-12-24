package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansDeleter;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansFinder;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansSaver;
import org.cyberborean.rdfbeans.RDFBeanManager;

public class DeleteBenchmarkRunner extends RDFBeansBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        persistData(new RdfBeansSaver(beanManager));
        System.gc();
        System.gc();
    }

    @Override
    public void tearDown() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        verifyDelete(new RdfBeansFinder(beanManager));
        super.tearDown();
    }

    @Override
    public void execute() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        executeDelete(new RdfBeansDeleter(beanManager));
    }
}
