package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

import javax.xml.datatype.XMLGregorianCalendar;
import java.net.URI;
import java.util.Set;

@Iri(Vocabulary.s_c_Event)
public interface Event extends cz.cvut.kbss.benchmark.model.Event<Event> {

    @Iri(Vocabulary.s_p_has_key)
    @Override
    String getKey();

    @Override
    void setKey(String key);

    @Iri(Vocabulary.s_p_has_start_time)
    XMLGregorianCalendar getStart();

    void setStart(XMLGregorianCalendar start);

    @Iri(Vocabulary.s_p_has_end_time)
    XMLGregorianCalendar getEnd();

    void setEnd(XMLGregorianCalendar end);

    @Iri(Vocabulary.s_p_has_event_type)
    @Override
    URI getEventType();

    @Override
    void setEventType(URI eventType);

    @Iri(Vocabulary.s_p_has_part)
    @Override
    Set<Event> getSubEvents();

    @Override
    void setSubEvents(Set<Event> subEvents);
}
