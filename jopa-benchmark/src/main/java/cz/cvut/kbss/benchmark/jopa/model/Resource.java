package cz.cvut.kbss.benchmark.jopa.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.jopa.model.annotations.Id;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;

import java.net.URI;

@OWLClass(iri = Vocabulary.s_c_Resource)
public class Resource implements cz.cvut.kbss.benchmark.model.Resource {

    @Id
    private URI uri;

    @OWLDataProperty(iri = Vocabulary.s_p_has_id)
    private String identifier;

    @OWLDataProperty(iri = Vocabulary.s_p_description)
    private String description;

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
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

    @Override
    public String toString() {
        return "Resource{" +
                "uri=" + uri +
                ", identifier='" + identifier + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
