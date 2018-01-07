package cz.cvut.kbss.benchmark.alibaba.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.openrdf.annotations.Iri;

import java.net.URI;
import java.util.Date;
import java.util.Set;

@Iri(Vocabulary.s_c_Event)
public class Event implements IEvent {

    private URI uri;

    private String key;

    private Date startTime;

    private Date endTime;

    private URI eventType;

    private Set<Event> subEvents;

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getId() {
        return uri.toString();
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public URI getEventType() {
        return eventType;
    }

    @Override
    public void setEventType(URI eventType) {
        this.eventType = eventType;
    }

    @Override
    public Set<Event> getSubEvents() {
        return subEvents;
    }

    public void setSubEvents(Set<Event> subEvents) {
        this.subEvents = subEvents;
    }

    @Override
    public String toString() {
        return "Event{" +
                "uri=" + uri +
                ", subEvents=" + subEvents +
                ", eventType=" + eventType +
                '}';
    }
}
