package cz.cvut.kbss.benchmark.rdfbeans.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.rdfbeans.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.Updater;
import org.cyberborean.rdfbeans.RDFBeanManager;
import org.cyberborean.rdfbeans.exceptions.RDFBeanException;

public class RdfBeansUpdater implements Updater<OccurrenceReport> {

    private final RDFBeanManager beanManager;

    public RdfBeansUpdater(RDFBeanManager beanManager) {
        this.beanManager = beanManager;
    }

    @Override
    public void begin() {
        beanManager.getRepositoryConnection().begin();
    }

    @Override
    public void commit() {
        beanManager.getRepositoryConnection().commit();
    }

    @Override
    public void update(OccurrenceReport report) {
        try {
            beanManager.update(report.getOccurrence());
            beanManager.update(report);
        } catch (RDFBeanException e) {
            throw new BenchmarkException(e);
        }
    }
}
