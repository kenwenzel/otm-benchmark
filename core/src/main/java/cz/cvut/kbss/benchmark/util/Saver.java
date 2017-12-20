package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.Person;

import java.util.Collection;

public interface Saver<P extends Person, R extends OccurrenceReport> {

    void begin();

    void commit();

    void persistAll(Collection<P> persons);

    void persist(R report);
}
