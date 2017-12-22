package cz.cvut.kbss.benchmark.alibaba.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.model.Occurrence;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.alibaba.model.Resource;
import cz.cvut.kbss.benchmark.util.Deleter;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

public class AliBabaDeleter implements Deleter<OccurrenceReport> {

    private final ObjectConnection connection;

    public AliBabaDeleter(ObjectConnection connection) {
        this.connection = connection;
    }

    @Override
    public void begin() {
        try {
            connection.begin();
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    public void delete(OccurrenceReport report) {
        try {
            final OccurrenceReport toDelete = connection.getObject(OccurrenceReport.class, report.getUri().toString());
            toDelete.setSeverityAssessment(null);
            toDelete.setDateCreated(null);
            toDelete.setLastModified(null);
            toDelete.setFileNumber(null);
            toDelete.setRevision(null);
            toDelete.setSummary(null);
            toDelete.getOccurrence().setName(null);
            toDelete.getOccurrence().setStartTime(null);
            toDelete.getOccurrence().setEndTime(null);
            connection.removeDesignation(toDelete.getOccurrence(), Occurrence.class);
            toDelete.setOccurrence(null);
            toDelete.setAuthor(null);
            toDelete.setLastModifiedBy(null);
            for (Resource a : toDelete.getAttachments()) {
                a.setIdentifier(null);
                a.setDescription(null);
                connection.removeDesignation(a, Resource.class);
            }
            toDelete.setAttachments(null);
            connection.removeDesignation(toDelete, OccurrenceReport.class);
        } catch (RepositoryException | QueryEvaluationException e) {
            e.printStackTrace();
        }
    }
}
