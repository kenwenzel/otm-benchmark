package cz.cvut.kbss.benchmark.empire.util;

import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.Updater;

import javax.persistence.EntityManager;

public class EmpireUpdater implements Updater<OccurrenceReport> {

    private final EntityManager em;

    public EmpireUpdater(EntityManager em) {
        this.em = em;
    }

    @Override
    public void begin() {
//        em.getTransaction().begin();
    }

    @Override
    public void commit() {
//        em.getTransaction().commit();
    }

    @Override
    public void update(OccurrenceReport report) {
        em.merge(report.getAuthor());
        em.merge(report);
    }
}
