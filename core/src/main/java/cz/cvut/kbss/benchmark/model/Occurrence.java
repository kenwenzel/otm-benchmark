package cz.cvut.kbss.benchmark.model;

import java.io.Serializable;
import java.util.Date;

public interface Occurrence extends Serializable {

    String getName();

    void setName(String name);

    Date getStartTime();

    void setStartTime(Date startTime);

    Date getEndTime();

    void setEndTime(Date endTime);
}
