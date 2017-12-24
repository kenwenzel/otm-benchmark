package cz.cvut.kbss.benchmark.rdfbeans.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.model.HasIdentifier;
import cz.cvut.kbss.benchmark.rdfbeans.model.Occurrence;
import cz.cvut.kbss.benchmark.rdfbeans.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.rdfbeans.model.Resource;
import cz.cvut.kbss.benchmark.util.Finder;
import org.cyberborean.rdfbeans.RDFBeanManager;
import org.cyberborean.rdfbeans.exceptions.RDFBeanException;

public class RdfBeansFinder implements Finder<OccurrenceReport> {

    private final RDFBeanManager beanManager;

    public RdfBeansFinder(RDFBeanManager beanManager) {
        this.beanManager = beanManager;
    }

    @Override
    public OccurrenceReport find(OccurrenceReport expected) {
        return find(OccurrenceReport.class, expected.getUri());
    }

    private <T> T find(Class<T> cls, String uri) {
        try {
            return beanManager.get(uri, cls);
        } catch (RDFBeanException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    public boolean exists(HasIdentifier instance) {
        try {
            return beanManager.get(instance.getId(), instance.getClass()) != null;
        } catch (RDFBeanException e) {
            throw new BenchmarkException(e);
        }
    }
}
