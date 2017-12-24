package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.HasIdentifier;
import cz.cvut.kbss.benchmark.model.OccurrenceReport;

public interface Finder<R extends OccurrenceReport> {

    R find(R expected);

    boolean exists(HasIdentifier instance);
}
