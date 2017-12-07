package cz.cvut.kbss.benchmark.alibaba.util;

import cz.cvut.kbss.benchmark.model.OccurrenceReport;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class BenchmarkUtil {

    private BenchmarkUtil() {
        throw new AssertionError();
    }

    public static void persistAll(ObjectConnection connection, List<OccurrenceReport> reports)
            throws RepositoryException {
        connection.begin();
        for (OccurrenceReport report : reports) {
            final cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport r = (cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport) report;
            connection.addObject(r.getUri().toString(), r);
            connection.addObject(r.getOccurrence().getUri().toString(), r.getOccurrence());
            if (connection.getObject(r.getAuthor().getUri().toString()) == null) {
                connection.addObject(r.getAuthor().getUri().toString(), r.getAuthor());
            }
            if (connection.getObject(r.getLastModifiedBy().getUri().toString()) == null) {
                connection.addObject(r.getLastModifiedBy().getUri().toString(), r.getAuthor());
            }
        }
        connection.commit();
    }

    public static void retrieveAll(ObjectConnection connection, List<OccurrenceReport> reports)
            throws QueryEvaluationException, RepositoryException {
        for (OccurrenceReport report : reports) {
            final cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport r = (cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport) report;
            final OccurrenceReport result = connection.getObject(OccurrenceReport.class, r.getUri().toString());
            assertNotNull(result);
            assertNotNull(result.getAuthor());
            assertNotNull(result.getLastModifiedBy());
            assertNotNull(result.getOccurrence());
        }
    }
}
