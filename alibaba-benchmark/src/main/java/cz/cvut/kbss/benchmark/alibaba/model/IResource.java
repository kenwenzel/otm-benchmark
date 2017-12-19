package cz.cvut.kbss.benchmark.alibaba.model;

import cz.cvut.kbss.benchmark.model.Resource;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.openrdf.annotations.Iri;

@Iri(Vocabulary.s_c_Resource)
public interface IResource extends Resource, HasUri {

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
