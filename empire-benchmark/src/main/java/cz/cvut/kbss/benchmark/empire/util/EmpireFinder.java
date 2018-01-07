package cz.cvut.kbss.benchmark.empire.util;

import com.clarkparsia.empire.SupportsRdfId;
import com.clarkparsia.empire.impl.RdfQuery;
import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.HasIdentifier;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.benchmark.util.Finder;

import javax.persistence.EntityManager;
import java.net.URI;
import java.util.Collection;

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
    public Collection<OccurrenceReport> findAll() {
        return em.createQuery("WHERE { ?result rdf:type <" + Vocabulary.s_c_occurrence_report + "> . }")
                 .setHint(RdfQuery.HINT_ENTITY_CLASS, OccurrenceReport.class).getResultList();
    }

    @Override
    public boolean exists(HasIdentifier instance) {
        return em.find(instance.getClass(), new SupportsRdfId.URIKey(URI.create(instance.getId()))) != null;
    }
}
