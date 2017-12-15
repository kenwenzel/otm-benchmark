package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.rdfbeans.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.AbstractBenchmarkUtil;
import org.cyberborean.rdfbeans.RDFBeanManager;
import org.cyberborean.rdfbeans.exceptions.RDFBeanException;

public class CreateBenchmarkRunner extends RDFBeansBenchmarkRunner {

    @Override
    public void tearDown() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        AbstractBenchmarkUtil.findAndVerifyAll(generator, r -> {
            try {
                return beanManager.get(((OccurrenceReport) r).getUri(), OccurrenceReport.class);
            } catch (RDFBeanException e) {
                throw new BenchmarkException(e);
            }
        });
        super.tearDown();
    }

    @Override
    public void execute() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        beanManager.getRepositoryConnection().begin();
        AbstractBenchmarkUtil.persistAll(generator, o -> {
            try {
                beanManager.add(o);
            } catch (RDFBeanException e) {
                throw new BenchmarkException(e);
            }
        });
        beanManager.getRepositoryConnection().commit();
    }
}
