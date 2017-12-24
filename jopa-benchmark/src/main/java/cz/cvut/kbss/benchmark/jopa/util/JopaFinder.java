package cz.cvut.kbss.benchmark.jopa.util;

import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.HasIdentifier;
import cz.cvut.kbss.benchmark.util.Finder;
import cz.cvut.kbss.jopa.model.EntityManager;

import java.net.URI;

public class JopaFinder implements Finder<OccurrenceReport> {

    private final EntityManager em;

    public JopaFinder(EntityManager em) {
        this.em = em;
    }

    @Override
    public OccurrenceReport find(OccurrenceReport expected) {
        return em.find(OccurrenceReport.class, expected.getUri());
    }

    @Override
    public boolean exists(HasIdentifier instance) {
        return em.find(instance.getClass(), URI.create(instance.getId())) != null;
    }
}
