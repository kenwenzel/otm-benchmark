package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.HasKey;
import cz.cvut.kbss.benchmark.model.OccurrenceReport;

import java.util.Collection;

public interface Finder<R extends OccurrenceReport> {

    R find(R expected);

    Collection<R> findAll();

    boolean exists(HasKey instance);
}
