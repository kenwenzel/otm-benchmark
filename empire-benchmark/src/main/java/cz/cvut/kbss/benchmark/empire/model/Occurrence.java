package cz.cvut.kbss.benchmark.empire.model;

import com.clarkparsia.empire.SupportsRdfId;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;
import com.clarkparsia.empire.annotation.SupportsRdfIdImpl;
import cz.cvut.kbss.benchmark.model.Vocabulary;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@RdfsClass(Vocabulary.s_c_Occurrence)
public class Occurrence implements SupportsRdfId, cz.cvut.kbss.benchmark.model.Occurrence {

    private SupportsRdfId mIdSupport = new SupportsRdfIdImpl();

    @RdfProperty(Vocabulary.s_p_label)
    private String name;

    @RdfProperty(Vocabulary.s_p_has_start_time)
    private Date startTime;

    @RdfProperty(Vocabulary.s_p_has_end_time)
    private Date endTime;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Occurrence{" + name + " <" + mIdSupport + ">}";
    }

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
}
