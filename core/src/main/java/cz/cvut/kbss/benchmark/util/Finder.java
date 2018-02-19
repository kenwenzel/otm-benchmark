package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.HasIdentifier;
import cz.cvut.kbss.benchmark.model.OccurrenceReport;

import java.util.Collection;

public interface Finder<R extends OccurrenceReport> {

    R find(R expected);

    Collection<R> findAll();

    boolean exists(HasIdentifier instance);

    void close();
}
