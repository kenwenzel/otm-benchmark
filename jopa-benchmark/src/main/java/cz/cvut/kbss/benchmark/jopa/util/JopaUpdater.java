package cz.cvut.kbss.benchmark.jopa.util;

import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.Updater;
import cz.cvut.kbss.jopa.model.EntityManager;

public class JopaUpdater implements Updater<OccurrenceReport> {

    private final EntityManager em;

    public JopaUpdater(EntityManager em) {
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
    public void update(OccurrenceReport report) {
        em.merge(report.getOccurrence());
        em.merge(report);
    }
}
