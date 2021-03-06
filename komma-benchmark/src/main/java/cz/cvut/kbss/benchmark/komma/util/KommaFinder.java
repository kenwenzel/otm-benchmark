package cz.cvut.kbss.benchmark.komma.util;

import cz.cvut.kbss.benchmark.komma.model.OccurrenceReport;
import net.enilink.komma.core.IEntityManager;
import net.enilink.komma.core.URI;

public class KommaFinder {

    private final IEntityManager em;

    public KommaFinder(IEntityManager em) {
        this.em = em;
    }

    public OccurrenceReport find(URI uri) {
        return em.find(uri, OccurrenceReport.class);
    }
}
