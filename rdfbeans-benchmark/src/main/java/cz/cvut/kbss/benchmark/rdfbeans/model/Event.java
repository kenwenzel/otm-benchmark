package cz.cvut.kbss.benchmark.rdfbeans.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.cyberborean.rdfbeans.annotations.RDF;
import org.cyberborean.rdfbeans.annotations.RDFBean;
import org.cyberborean.rdfbeans.annotations.RDFSubject;

import java.net.URI;
import java.util.Date;
import java.util.Set;

@RDFBean(Vocabulary.s_c_Event)
public class Event implements cz.cvut.kbss.benchmark.model.Event<Event> {

    private String uri;

    private String key;

    private Date startTime;

    private Date endTime;

    private URI eventType;

    private Set<Event> subEvents;

    @RDFSubject
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @RDF(Vocabulary.s_p_has_key)
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
        return uri;
    }

    @RDF(Vocabulary.s_p_has_start_time)
    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @RDF(Vocabulary.s_p_has_end_time)
    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @RDF(Vocabulary.s_p_has_event_type)
    @Override
    public URI getEventType() {
        return eventType;
    }

    @Override
    public void setEventType(URI eventType) {
        this.eventType = eventType;
    }

    @RDF(Vocabulary.s_p_has_part)
    @Override
    public Set<Event> getSubEvents() {
        return subEvents;
    }

    @Override
    public void setSubEvents(Set<Event> subEvents) {
        this.subEvents = subEvents;
    }

    @Override
    public String toString() {
        return "Event{" +
                "uri='" + uri + '\'' +
                ", eventType=" + eventType +
                ", subEvents=" + subEvents +
                '}';
    }
}
