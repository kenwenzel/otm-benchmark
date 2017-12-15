package cz.cvut.kbss.benchmark.rdfbeans.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.cyberborean.rdfbeans.annotations.RDF;
import org.cyberborean.rdfbeans.annotations.RDFBean;
import org.cyberborean.rdfbeans.annotations.RDFSubject;

import java.util.Date;

@RDFBean(Vocabulary.s_c_Occurrence)
public class Occurrence implements cz.cvut.kbss.benchmark.model.Occurrence {

    private String uri;

    private String name;

    private Date startTime;

    private Date endTime;

    @RDFSubject
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @RDF(Vocabulary.s_p_label)
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @RDF(Vocabulary.s_p_has_start_time)
    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @RDF(Vocabulary.s_p_has_end_time)
    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
