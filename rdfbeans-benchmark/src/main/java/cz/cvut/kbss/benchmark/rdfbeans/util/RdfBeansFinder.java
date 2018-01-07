package cz.cvut.kbss.benchmark.rdfbeans.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.model.HasIdentifier;
import cz.cvut.kbss.benchmark.rdfbeans.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.Finder;
import org.cyberborean.rdfbeans.RDFBeanManager;
import org.cyberborean.rdfbeans.exceptions.RDFBeanException;
import org.eclipse.rdf4j.common.iteration.CloseableIteration;
import org.eclipse.rdf4j.common.iteration.Iterations;

import java.util.Collection;
import java.util.List;

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
    public Collection<OccurrenceReport> findAll() {
        try {
            final CloseableIteration<OccurrenceReport, ?> it = beanManager.getAll(OccurrenceReport.class);
            final List<OccurrenceReport> result = Iterations.asList(it);
            it.close();
            return result;
        } catch (Exception e) {
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
