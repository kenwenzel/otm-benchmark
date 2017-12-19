package cz.cvut.kbss.benchmark.empire.model;

import com.clarkparsia.empire.SupportsRdfId;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;
import com.clarkparsia.empire.annotation.SupportsRdfIdImpl;
import cz.cvut.kbss.benchmark.model.Vocabulary;

@RdfsClass(Vocabulary.s_c_Resource)
public class Resource implements SupportsRdfId, cz.cvut.kbss.benchmark.model.Resource {

    private SupportsRdfId mIdSupport = new SupportsRdfIdImpl();

    @RdfProperty(Vocabulary.s_p_has_id)
    private String identifier;

    @RdfProperty(Vocabulary.s_p_description)
    private String description;

    @Override
    public RdfKey getRdfId() {
        return mIdSupport.getRdfId();
    }

    @Override
    public void setRdfId(RdfKey rdfKey) {
        mIdSupport.setRdfId(rdfKey);
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
