package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

@Iri(Vocabulary.s_c_Resource)
public interface Resource {

    @Iri(Vocabulary.s_p_has_key)
    String getKey();

    void setKey(String key);

    @Iri(Vocabulary.s_p_has_id)
    String getIdentifier();

    void setIdentifier(String identifier);

    @Iri(Vocabulary.s_p_description)
    String getDescription();

    void setDescription(String description);
}
