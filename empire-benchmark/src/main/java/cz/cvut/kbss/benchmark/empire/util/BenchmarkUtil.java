package cz.cvut.kbss.benchmark.empire.util;

import cz.cvut.kbss.benchmark.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.AbstractBenchmarkUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class BenchmarkUtil {

    private BenchmarkUtil() {
        throw new AssertionError();
    }

    public static void persistAll(EntityManager em, List<OccurrenceReport> reports) {
        for (OccurrenceReport r : reports) {
            em.persist(r);
            em.persist(r.getOccurrence());
            if (!em.contains(r.getAuthor())) {
                em.persist(r.getAuthor());
            }
            if (!em.contains(r.getLastModifiedBy())) {
                em.persist(r.getLastModifiedBy());
            }
        }
    }

    public static void readAll(final EntityManager em, List<OccurrenceReport> reports) {
        reports.forEach(r -> {
            final OccurrenceReport result = em.find(cz.cvut.kbss.benchmark.empire.model.OccurrenceReport.class,
                    ((cz.cvut.kbss.benchmark.empire.model.OccurrenceReport) r).getRdfId());
            AbstractBenchmarkUtil.checkReport(result);
        });
    }
}
