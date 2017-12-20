package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.rdfbeans.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansSaver;
import org.cyberborean.rdfbeans.RDFBeanManager;
import org.cyberborean.rdfbeans.exceptions.RDFBeanException;

public class CreateBenchmarkRunner extends RDFBeansBenchmarkRunner {

    @Override
    public void tearDown() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        findAndVerifyAll(r -> {
            try {
                return beanManager.get(r.getUri(), OccurrenceReport.class);
            } catch (RDFBeanException e) {
                throw new BenchmarkException(e);
            }
        });
        super.tearDown();
    }

    @Override
    public void execute() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        executeCreate(new RdfBeansSaver(beanManager));
    }
}
