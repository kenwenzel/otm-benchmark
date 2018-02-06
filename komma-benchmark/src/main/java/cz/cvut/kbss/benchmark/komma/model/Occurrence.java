package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

@Iri(Vocabulary.s_c_Occurrence)
public interface Occurrence extends Event {

    @Iri(Vocabulary.s_p_label)
    String getName();

    void setName(String name);
}
