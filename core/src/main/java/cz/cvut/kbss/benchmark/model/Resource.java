package cz.cvut.kbss.benchmark.model;

import java.io.Serializable;

public interface Resource extends Serializable {

    /**
     * Can be for example file name, or a URL.
     *
     * @return identifier value
     */
    String getIdentifier();

    void setIdentifier(String identifier);

    String getDescription();

    void setDescription(String description);
}
