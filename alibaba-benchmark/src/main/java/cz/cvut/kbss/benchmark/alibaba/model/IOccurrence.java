package cz.cvut.kbss.benchmark.alibaba.model;

import cz.cvut.kbss.benchmark.model.Occurrence;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.openrdf.annotations.Iri;

import java.util.Date;

@Iri(Vocabulary.s_c_Occurrence)
public interface IOccurrence extends Occurrence, HasUri {

    @Iri(Vocabulary.s_p_label)
    @Override
    String getName();

    @Iri(Vocabulary.s_p_label)
    @Override
    void setName(String name);

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
}
