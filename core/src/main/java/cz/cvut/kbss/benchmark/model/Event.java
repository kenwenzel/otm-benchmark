package cz.cvut.kbss.benchmark.model;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import java.util.Set;

public interface Event<T extends Event> extends Serializable, HasIdentifier, HasKey {

    Date getStartTime();

    void setStartTime(Date startTime);

    Date getEndTime();

    void setEndTime(Date endTime);

    URI getEventType();

    void setEventType(URI eventType);

    Set<T> getSubEvents();

    void setSubEvents(Set<T> subEvents);
}
