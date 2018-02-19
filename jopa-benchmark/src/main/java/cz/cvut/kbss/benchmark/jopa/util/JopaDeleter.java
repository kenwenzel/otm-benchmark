package cz.cvut.kbss.benchmark.jopa.util;

import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.Deleter;
import cz.cvut.kbss.jopa.model.EntityManager;

public class JopaDeleter implements Deleter<OccurrenceReport> {

    private final EntityManager em;

    public JopaDeleter(EntityManager em) {
        this.em = em;
    }

    @Override
    public void begin() {
        em.getTransaction().begin();
    }

    @Override
    public void commit() {
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        em.close();
    }

    @Override
    public void delete(OccurrenceReport report) {
        final OccurrenceReport r = em.find(OccurrenceReport.class, report.getUri());
        em.remove(r.getOccurrence());
        em.remove(r);
    }
}
