package cz.cvut.kbss.benchmark.jopa.model;

import com.sun.xml.internal.org.jvnet.fastinfoset.VocabularyApplicationData;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.jopa.model.annotations.*;

import java.net.URI;
import java.util.Date;
import java.util.Set;

@OWLClass(iri = Vocabulary.s_c_Event)
public class Event implements cz.cvut.kbss.benchmark.model.Event<Event> {

    @Id
    private URI uri;

    @OWLDataProperty(iri = Vocabulary.s_p_has_key)
    private String key;

    @OWLDataProperty(iri = Vocabulary.s_p_has_start_time)
    private Date startTime;

    @OWLDataProperty(iri = Vocabulary.s_p_has_end_time)
    private Date endTime;

    @OWLObjectProperty(iri = Vocabulary.s_p_has_part, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> subEvents;

    @OWLObjectProperty(iri = Vocabulary.s_p_has_event_type)
    private URI eventType;

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
    public Set<Event> getSubEvents() {
        return subEvents;
    }

    public void setSubEvents(Set<Event> subEvents) {
        this.subEvents = subEvents;
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
    public String toString() {
        return "Event{" +
                "uri=" + uri +
                ", subEvents=" + subEvents +
                ", eventType=" + eventType +
                '}';
    }
}
