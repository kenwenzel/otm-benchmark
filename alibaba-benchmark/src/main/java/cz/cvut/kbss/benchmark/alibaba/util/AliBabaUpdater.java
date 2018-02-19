package cz.cvut.kbss.benchmark.alibaba.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.alibaba.model.Resource;
import cz.cvut.kbss.benchmark.util.Updater;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

public class AliBabaUpdater implements Updater<OccurrenceReport> {

    private final ObjectConnection connection;

    public AliBabaUpdater(ObjectConnection connection) {
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
    public void close() {
        try {
            connection.close();
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    public void update(OccurrenceReport report) {
        try {
            final OccurrenceReport toUpdate = connection.getObject(OccurrenceReport.class, report.getUri().toString());
            toUpdate.setLastModifiedBy(report.getLastModifiedBy());
            toUpdate.setLastModified(report.getLastModified());
            toUpdate.setRevision(report.getRevision());
            toUpdate.getOccurrence().setName(report.getOccurrence().getName());
            toUpdate.setSeverityAssessment(report.getSeverityAssessment());
            toUpdate.setAttachments(report.getAttachments());
            for (Resource r : report.getAttachments()) {
                if (!connection
                        .hasStatement(connection.getValueFactory().createURI(r.getUri().toString()), null, null)) {
                    connection.addObject(r.getUri().toString(), r);
                }
            }
        } catch (QueryEvaluationException | RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }
}
