package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

@Iri(Vocabulary.s_c_Occurrence)
public interface Occurrence extends Event, cz.cvut.kbss.benchmark.model.Occurrence<Event> {

    @Iri(Vocabulary.s_p_label)
    @Override
    String getName();

    @Override
    void setName(String name);
}
