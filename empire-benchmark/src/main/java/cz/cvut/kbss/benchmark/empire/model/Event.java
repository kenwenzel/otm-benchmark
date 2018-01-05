package cz.cvut.kbss.benchmark.empire.model;

import com.clarkparsia.empire.SupportsRdfId;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;
import com.clarkparsia.empire.annotation.SupportsRdfIdImpl;
import cz.cvut.kbss.benchmark.model.Vocabulary;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.net.URI;
import java.util.Date;
import java.util.Set;

@Entity
@RdfsClass(Vocabulary.s_c_Event)
public class Event implements cz.cvut.kbss.benchmark.model.Event<Event>, SupportsRdfId {

    private SupportsRdfId mIdSupport = new SupportsRdfIdImpl();

    @RdfProperty(Vocabulary.s_p_has_start_time)
    private Date startTime;

    @RdfProperty(Vocabulary.s_p_has_end_time)
    private Date endTime;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @RdfProperty(Vocabulary.s_p_has_part)
    private Set<Event> subEvents;

    @RdfProperty(Vocabulary.s_p_has_event_type)
    private URI eventType;

    @Override
    public RdfKey getRdfId() {
        return mIdSupport.getRdfId();
    }

    @Override
    public void setRdfId(RdfKey rdfKey) {
        mIdSupport.setRdfId(rdfKey);
    }

    @Override
    public String getId() {
        return getRdfId().value().toString();
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

    @Override
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
                "id=" + getId() +
                ", subEvents=" + subEvents +
                ", eventType=" + eventType +
                '}';
    }
}
