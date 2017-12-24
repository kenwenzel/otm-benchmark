package cz.cvut.kbss.benchmark.empire.util;

import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.Deleter;

import javax.persistence.EntityManager;

public class EmpireDeleter implements Deleter<OccurrenceReport> {

    private final EntityManager em;

    public EmpireDeleter(EntityManager em) {
        this.em = em;
    }

    @Override
    public void begin() {
        // Do nothing, Empire has problems with user-managed transactions
    }

    @Override
    public void commit() {
        // Do nothing
    }

    @Override
    public void delete(OccurrenceReport report) {
        final OccurrenceReport toDelete = em.getReference(OccurrenceReport.class, report.getRdfId());
        em.remove(toDelete.getOccurrence());
        em.remove(toDelete);
    }
}
