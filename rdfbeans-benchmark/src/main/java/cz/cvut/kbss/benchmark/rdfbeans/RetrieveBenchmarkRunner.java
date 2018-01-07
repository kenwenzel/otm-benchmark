package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansFinder;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansSaver;
import org.cyberborean.rdfbeans.RDFBeanManager;

public class RetrieveBenchmarkRunner extends RDFBeansBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        persistData(new RdfBeansSaver(beanManager));
        System.gc();
        System.gc();
    }

    @Override
    public void execute() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        executeRetrieve(new RdfBeansFinder(beanManager));
    }
}
