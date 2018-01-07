package cz.cvut.kbss.benchmark.alibaba.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.openrdf.annotations.Iri;

import java.net.URI;
import java.util.Date;
import java.util.Set;

@Iri(Vocabulary.s_c_Event)
public interface IEvent extends cz.cvut.kbss.benchmark.model.Event<Event> {

    @Iri(Vocabulary.s_p_has_key)
    @Override
    String getKey();

    @Override
    void setKey(String key);

    @Iri(Vocabulary.s_p_has_start_time)
    @Override
    Date getStartTime();

    @Iri(Vocabulary.s_p_has_start_time)
    @Override
    void setStartTime(Date startTime);

    @Iri(Vocabulary.s_p_has_end_time)
    @Override
    Date getEndTime();

    @Iri(Vocabulary.s_p_has_end_time)
    @Override
    void setEndTime(Date endTime);

    @Iri(Vocabulary.s_p_has_event_type)
    @Override
    URI getEventType();

    @Iri(Vocabulary.s_p_has_event_type)
    @Override
    void setEventType(URI eventType);

    @Iri(Vocabulary.s_p_has_part)
    @Override
    Set<Event> getSubEvents();

    @Iri(Vocabulary.s_p_has_part)
    @Override
    void setSubEvents(Set<Event> subEvents);
}
