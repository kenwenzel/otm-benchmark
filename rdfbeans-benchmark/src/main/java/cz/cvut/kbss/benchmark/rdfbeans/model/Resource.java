package cz.cvut.kbss.benchmark.rdfbeans.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.cyberborean.rdfbeans.annotations.RDF;
import org.cyberborean.rdfbeans.annotations.RDFBean;
import org.cyberborean.rdfbeans.annotations.RDFSubject;

import java.util.Objects;

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

    @Override
    public String getKey() {
        return uri;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;
        Resource resource = (Resource) o;
        return Objects.equals(uri, resource.uri) &&
                Objects.equals(identifier, resource.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, identifier);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "uri='" + uri + '\'' +
                ", identifier='" + identifier + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
