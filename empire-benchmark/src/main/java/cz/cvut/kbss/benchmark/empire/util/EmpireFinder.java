package cz.cvut.kbss.benchmark.empire.util;

import cz.cvut.kbss.benchmark.empire.model.Occurrence;
import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.empire.model.Resource;
import cz.cvut.kbss.benchmark.util.Finder;

import javax.persistence.EntityManager;

public class EmpireFinder implements Finder<OccurrenceReport, Occurrence, Resource> {

    private final EntityManager em;

    public EmpireFinder(EntityManager em) {
        this.em = em;
    }

    @Override
    public OccurrenceReport find(OccurrenceReport expected) {
        return em.find(OccurrenceReport.class, expected.getRdfId());
    }

    @Override
    public Occurrence find(Occurrence expected) {
        return em.find(Occurrence.class, expected.getRdfId());
    }

    @Override
    public Resource find(Resource expected) {
        return em.find(Resource.class, expected.getRdfId());
    }
}
