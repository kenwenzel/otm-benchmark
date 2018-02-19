package cz.cvut.kbss.benchmark.util;

public interface Transactional {

    void begin();

    void commit();

    void close();
}
