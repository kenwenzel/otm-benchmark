package cz.cvut.kbss.benchmark.alibaba.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.model.*;
import cz.cvut.kbss.benchmark.util.Deleter;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

import java.util.Set;

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
            final Occurrence occurrence = connection.getObject(Occurrence.class, report.getOccurrence().getId());
            occurrence.setName(null);
            occurrence.setStartTime(null);
            occurrence.setEndTime(null);
            deleteEvents(report.getOccurrence().getSubEvents());
            occurrence.setEventType(null);
            occurrence.setSubEvents(null);
            connection.removeDesignation(occurrence, Occurrence.class);
            toDelete.setOccurrence(null);
            toDelete.setAuthor(null);
            toDelete.setLastModifiedBy(null);
            for (Resource a : report.getAttachments()) {
                final Resource resource = connection.getObject(Resource.class, a.getId());
                resource.setIdentifier(null);
                resource.setDescription(null);
                connection.removeDesignation(resource, Resource.class);
            }
            toDelete.setAttachments(null);
            connection.removeDesignation(toDelete, OccurrenceReport.class);
        } catch (RepositoryException | QueryEvaluationException e) {
            e.printStackTrace();
        }
    }

    private void deleteEvents(Set<Event> events) throws QueryEvaluationException, RepositoryException {
        if (events == null) {
            return;
        }
        for (Event e : events) {
            final Event toDelete = connection.getObject(Event.class, e.getId());
            toDelete.setStartTime(null);
            toDelete.setEndTime(null);
            toDelete.setEventType(null);
            deleteEvents(e.getSubEvents());
            toDelete.setSubEvents(null);
            connection.removeDesignation(toDelete, Event.class);
        }
    }
}
