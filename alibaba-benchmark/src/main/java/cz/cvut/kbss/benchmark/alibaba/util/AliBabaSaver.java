package cz.cvut.kbss.benchmark.alibaba.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.model.Event;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.alibaba.model.Person;
import cz.cvut.kbss.benchmark.alibaba.model.Resource;
import cz.cvut.kbss.benchmark.util.Saver;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

import java.util.Collection;
import java.util.Set;

public class AliBabaSaver implements Saver<Person, OccurrenceReport> {

    private final ObjectConnection connection;

    public AliBabaSaver(ObjectConnection connection) {
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
    public void persistAll(Collection<Person> persons) {
        try {
            for (Person p : persons) {
                connection.addObject(p.getUri().toString(), p);
            }
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    public void persist(OccurrenceReport report) {
        try {
            connection.addObject(report.getUri().toString(), report);
            connection.addObject(report.getOccurrence().getUri().toString(), report.getOccurrence());
            for (Resource a : report.getAttachments()) {
                connection.addObject(a.getUri().toString(), a);
            }
            persistEvents(report.getOccurrence().getSubEvents());
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }

    private void persistEvents(Set<Event> events) throws RepositoryException {
        if (events != null) {
            for (Event e : events) {
                connection.addObject(e.getUri().toString(), e);
                persistEvents(e.getSubEvents());
            }
        }
    }
}
