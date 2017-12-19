package cz.cvut.kbss.benchmark.alibaba.model;

import java.net.URI;

public class Resource implements IResource {

    private URI uri;

    private String identifier;

    private String description;

    @Override
    public URI getUri() {
        return uri;
    }

    @Override
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
