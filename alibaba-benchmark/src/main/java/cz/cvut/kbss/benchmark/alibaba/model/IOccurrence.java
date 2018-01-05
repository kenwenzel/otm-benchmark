package cz.cvut.kbss.benchmark.alibaba.model;

import cz.cvut.kbss.benchmark.model.Occurrence;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.openrdf.annotations.Iri;

import java.util.Date;

@Iri(Vocabulary.s_c_Occurrence)
public interface IOccurrence extends IEvent, Occurrence<Event> {

    @Iri(Vocabulary.s_p_label)
    @Override
    String getName();

    @Iri(Vocabulary.s_p_label)
    @Override
    void setName(String name);
}
