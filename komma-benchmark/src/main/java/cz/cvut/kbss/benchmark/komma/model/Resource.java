package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

@Iri(Vocabulary.s_c_Resource)
public interface Resource extends cz.cvut.kbss.benchmark.model.Resource {

    @Iri(Vocabulary.s_p_has_id)
    @Override
    String getIdentifier();

    @Override
    void setIdentifier(String identifier);

    @Iri(Vocabulary.s_p_description)
    @Override
    String getDescription();

    @Override
    void setDescription(String description);
}
