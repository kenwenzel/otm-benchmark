package cz.cvut.kbss.benchmark.empire.util;

import com.clarkparsia.empire.SupportsRdfId;
import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.HasIdentifier;
import cz.cvut.kbss.benchmark.util.Finder;

import javax.persistence.EntityManager;
import java.net.URI;

public class EmpireFinder implements Finder<OccurrenceReport> {

    private final EntityManager em;

    public EmpireFinder(EntityManager em) {
        this.em = em;
    }

    @Override
    public OccurrenceReport find(OccurrenceReport expected) {
        return em.find(OccurrenceReport.class, expected.getRdfId());
    }

    @Override
    public boolean exists(HasIdentifier instance) {
        return em.find(instance.getClass(), new SupportsRdfId.URIKey(URI.create(instance.getId()))) != null;
    }
}
