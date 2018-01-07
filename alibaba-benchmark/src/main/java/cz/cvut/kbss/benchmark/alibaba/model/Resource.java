package cz.cvut.kbss.benchmark.alibaba.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.openrdf.annotations.Iri;

import java.net.URI;
import java.util.Objects;

@Iri(Vocabulary.s_c_Resource)
public class Resource implements IResource {

    private URI uri;

    private String key;

    private String identifier;

    private String description;

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;
        Resource resource = (Resource) o;
        return Objects.equals(getKey(), resource.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey());
    }

    @Override
    public String toString() {
        return "Resource{ identifier='" + getKey() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
