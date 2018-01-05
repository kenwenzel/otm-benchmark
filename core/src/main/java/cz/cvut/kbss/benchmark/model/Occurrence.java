package cz.cvut.kbss.benchmark.model;

public interface Occurrence<T extends Event> extends Event<T> {

    String getName();

    void setName(String name);
}
