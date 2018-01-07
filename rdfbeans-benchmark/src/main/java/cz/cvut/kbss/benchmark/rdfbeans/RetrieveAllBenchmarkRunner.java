package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansFinder;
import org.cyberborean.rdfbeans.RDFBeanManager;

public class RetrieveAllBenchmarkRunner extends RetrieveBenchmarkRunner {

    @Override
    public void execute() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        executeRetrieveAll(new RdfBeansFinder(beanManager));
    }
}
