package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.rdfbeans.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansSaver;
import cz.cvut.kbss.benchmark.rdfbeans.util.RdfBeansUpdater;
import org.cyberborean.rdfbeans.RDFBeanManager;
import org.cyberborean.rdfbeans.exceptions.RDFBeanException;

public class UpdateBenchmarkRunner extends RDFBeansBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        generator.generate();
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        persistData(new RdfBeansSaver(beanManager));
        System.gc();
        System.gc();
    }

    @Override
    public void tearDown() {
        final RDFBeanManager beanManager = persistenceFactory.beanManager();
        verifyUpdates(r -> {
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
        executeUpdate(new RdfBeansUpdater(beanManager));
    }
}
