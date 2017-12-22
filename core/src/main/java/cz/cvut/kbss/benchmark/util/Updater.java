package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.OccurrenceReport;

public interface Updater<R extends OccurrenceReport> extends Transactional {

    void update(R report);
}
