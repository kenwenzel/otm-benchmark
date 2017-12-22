package cz.cvut.kbss.benchmark.jopa.util;

import cz.cvut.kbss.benchmark.jopa.model.Occurrence;
import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.jopa.model.Resource;
import cz.cvut.kbss.benchmark.util.Finder;
import cz.cvut.kbss.jopa.model.EntityManager;

public class JopaFinder implements Finder<OccurrenceReport, Occurrence, Resource> {

    private final EntityManager em;

    public JopaFinder(EntityManager em) {
        this.em = em;
    }

    @Override
    public OccurrenceReport find(OccurrenceReport expected) {
        return em.find(OccurrenceReport.class, expected.getUri());
    }

    @Override
    public Occurrence find(Occurrence expected) {
        return em.find(Occurrence.class, expected.getUri());
    }

    @Override
    public Resource find(Resource expected) {
        return em.find(Resource.class, expected.getUri());
    }
}
