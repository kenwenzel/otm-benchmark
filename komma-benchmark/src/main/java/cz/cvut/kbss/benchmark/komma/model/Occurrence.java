package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static cz.cvut.kbss.benchmark.komma.util.BenchmarkUtil.datatypeFactory;

@Iri(Vocabulary.s_c_Occurrence)
public interface Occurrence extends cz.cvut.kbss.benchmark.model.Occurrence {

    @Iri(Vocabulary.s_p_label)
    @Override
    String getName();

    @Override
    default Date getStartTime() {
        return getStart().toGregorianCalendar().getTime();
    }

    @Override
    default void setStartTime(Date startTime) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(startTime);
        setStart(datatypeFactory().newXMLGregorianCalendar(c));
    }

    @Override
    default Date getEndTime() {
        return getEnd().toGregorianCalendar().getTime();
    }

    @Override
    default void setEndTime(Date endTime) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(endTime);
        setEnd(datatypeFactory().newXMLGregorianCalendar(c));
    }

    @Iri(Vocabulary.s_p_has_start_time)
    XMLGregorianCalendar getStart();

    void setStart(XMLGregorianCalendar start);

    @Iri(Vocabulary.s_p_has_end_time)
    XMLGregorianCalendar getEnd();

    void setEnd(XMLGregorianCalendar end);
}
