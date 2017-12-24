package cz.cvut.kbss.benchmark.empire.model;

import com.clarkparsia.empire.SupportsRdfId;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;
import com.clarkparsia.empire.annotation.SupportsRdfIdImpl;
import cz.cvut.kbss.benchmark.model.Vocabulary;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
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
    public String getId() {
        return getRdfId().value().toString();
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
                "mIdSupport=" + mIdSupport +
                ", identifier='" + identifier + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;
        Resource resource = (Resource) o;
        return Objects.equals(mIdSupport, resource.mIdSupport) &&
                Objects.equals(identifier, resource.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mIdSupport, identifier);
    }
}
