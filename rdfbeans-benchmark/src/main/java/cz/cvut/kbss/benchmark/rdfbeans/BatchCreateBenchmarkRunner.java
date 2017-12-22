package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansSaver;
import org.cyberborean.rdfbeans.RDFBeanManager;

public class BatchCreateBenchmarkRunner extends CreateBenchmarkRunner {

    @Override
    public void execute() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        executeBatchCreate(new RdfBeansSaver(beanManager));
    }
}
