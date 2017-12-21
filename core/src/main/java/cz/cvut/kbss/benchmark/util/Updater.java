package cz.cvut.kbss.benchmark.util;

import cz.cvut.kbss.benchmark.model.OccurrenceReport;

public interface Updater<R extends OccurrenceReport> {

    void begin();

    void commit();

    void update(R report);
}
