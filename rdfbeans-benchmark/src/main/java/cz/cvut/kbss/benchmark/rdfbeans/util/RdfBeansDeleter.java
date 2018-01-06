package cz.cvut.kbss.benchmark.rdfbeans.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.rdfbeans.model.Event;
import cz.cvut.kbss.benchmark.rdfbeans.model.Occurrence;
import cz.cvut.kbss.benchmark.rdfbeans.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.rdfbeans.model.Resource;
import cz.cvut.kbss.benchmark.util.Deleter;
import org.cyberborean.rdfbeans.RDFBeanManager;
import org.cyberborean.rdfbeans.exceptions.RDFBeanException;

import java.util.Set;

public class RdfBeansDeleter implements Deleter<OccurrenceReport> {

    private final RDFBeanManager beanManager;

    public RdfBeansDeleter(RDFBeanManager beanManager) {
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
    public void delete(OccurrenceReport report) {
        try {
            deleteEvents(report.getOccurrence().getSubEvents());
            beanManager.delete(report.getOccurrence().getUri(), Occurrence.class);
            for (Resource a : report.getAttachments()) {
                beanManager.delete(a.getUri(), Resource.class);
            }
            beanManager.delete(report.getUri(), OccurrenceReport.class);
        } catch (RDFBeanException e) {
            throw new BenchmarkException(e);
        }
    }

    private void deleteEvents(Set<Event> events) throws RDFBeanException {
        if (events == null) {
            return;
        }
        for (Event e : events) {
            deleteEvents(e.getSubEvents());
            beanManager.delete(e.getUri(), Event.class);
        }
    }
}
