package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.Occurrence;
import cz.cvut.kbss.benchmark.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.Resource;

public interface Finder<R extends OccurrenceReport, O extends Occurrence, A extends Resource> {

    R find(R expected);

    O find(O expected);

    A find(A expected);
}
