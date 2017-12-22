package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.OccurrenceReport;

public interface Deleter<R extends OccurrenceReport> extends Transactional {

    void delete(R report);
}
