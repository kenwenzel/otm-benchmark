package cz.cvut.kbss.benchmark.jopa.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.jopa.model.annotations.Id;
import cz.cvut.kbss.jopa.model.annotations.OWLAnnotationProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;

import java.net.URI;
import java.util.Date;

@OWLClass(iri = Vocabulary.s_c_Occurrence)
public class Occurrence implements cz.cvut.kbss.benchmark.model.Occurrence {

    @Id
    private URI uri;

    @OWLAnnotationProperty(iri = Vocabulary.s_p_label)
    private String name;

    @OWLDataProperty(iri = Vocabulary.s_p_has_start_time)
    private Date startTime;

    @OWLDataProperty(iri = Vocabulary.s_p_has_end_time)
    private Date endTime;

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

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
        return "Occurrence{" + name + " <" + uri + ">}";
    }
}
