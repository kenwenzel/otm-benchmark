package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansFinder;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansSaver;
import org.cyberborean.rdfbeans.RDFBeanManager;

public class CreateBenchmarkRunner extends RDFBeansBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        persistPersons(new RdfBeansSaver(beanManager));
    }

    @Override
    public void tearDown() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        findAndVerifyAll(new RdfBeansFinder(beanManager));
        super.tearDown();
    }

    @Override
    public void execute() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        executeCreate(new RdfBeansSaver(beanManager));
    }
}
