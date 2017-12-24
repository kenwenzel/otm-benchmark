package cz.cvut.kbss.benchmark.alibaba.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.HasIdentifier;
import cz.cvut.kbss.benchmark.util.Finder;
import org.openrdf.annotations.Iri;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.object.ObjectConnection;

public class AliBabaFinder implements Finder<OccurrenceReport> {

    private final ObjectConnection connection;

    public AliBabaFinder(ObjectConnection connection) {
        this.connection = connection;
    }

    @Override
    public OccurrenceReport find(OccurrenceReport expected) {
        try {
            return connection.getObject(OccurrenceReport.class, expected.getUri().toString());
        } catch (RepositoryException | QueryEvaluationException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    public boolean exists(HasIdentifier instance) {
        final Class<?> cls = instance.getClass();
        assert cls.getDeclaredAnnotation(Iri.class) != null;
        final String typeUri = cls.getDeclaredAnnotation(Iri.class).value();
        final ValueFactory vf = connection.getValueFactory();
        try {
            return connection.hasStatement(vf.createURI(instance.getId()), RDF.TYPE, vf.createURI(typeUri));
        } catch (RepositoryException e) {
            throw new BenchmarkException(e);
        }
    }
}
