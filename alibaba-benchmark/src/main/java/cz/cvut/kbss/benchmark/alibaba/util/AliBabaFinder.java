package cz.cvut.kbss.benchmark.alibaba.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.model.Occurrence;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.alibaba.model.Resource;
import cz.cvut.kbss.benchmark.util.Finder;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

public class AliBabaFinder implements Finder<OccurrenceReport, Occurrence, Resource> {

    private final ObjectConnection connection;

    public AliBabaFinder(ObjectConnection connection) {
        this.connection = connection;
    }

    @Override
    public OccurrenceReport find(OccurrenceReport expected) {
        return find(OccurrenceReport.class, expected.getUri().toString());
    }

    private <T> T find(Class<T> cls, String uri) {
        try {
            return connection.getObject(cls, uri);
        } catch (RepositoryException | QueryEvaluationException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    public Occurrence find(Occurrence expected) {
        return find(Occurrence.class, expected.getUri().toString());
    }

    @Override
    public Resource find(Resource expected) {
        return find(Resource.class, expected.getUri().toString());
    }
}
