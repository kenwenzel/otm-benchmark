package cz.cvut.kbss.benchmark.rdfbeans.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.cyberborean.rdfbeans.annotations.RDF;
import org.cyberborean.rdfbeans.annotations.RDFBean;
import org.cyberborean.rdfbeans.annotations.RDFSubject;

@RDFBean(Vocabulary.s_c_Resource)
public class Resource implements cz.cvut.kbss.benchmark.model.Resource {

    private String uri;

    private String identifier;

    private String description;

    @RDFSubject
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @RDF(Vocabulary.s_p_has_id)
    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @RDF(Vocabulary.s_p_description)
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
