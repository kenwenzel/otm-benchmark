package cz.cvut.kbss.benchmark.jopa.util;

import cz.cvut.kbss.benchmark.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.util.AbstractBenchmarkUtil;
import cz.cvut.kbss.jopa.model.EntityManager;

import java.util.List;

public class BenchmarkUtil {

    public static void persistAll(EntityManager em, List<OccurrenceReport> reports) {
        for (OccurrenceReport r : reports) {
            em.persist(r);
            if (!em.contains(r.getAuthor())) {
                em.persist(r.getAuthor());
            }
            if (!em.contains(r.getLastModifiedBy())) {
                em.persist(r.getLastModifiedBy());
            }
        }
    }

    public static void retrieveAll(EntityManager em, List<OccurrenceReport> reports) {
        reports.forEach(r -> {
            final OccurrenceReport result = em.find(cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport.class,
                    ((cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport) r).getUri());
            AbstractBenchmarkUtil.checkReport(result);
        });
    }
}
