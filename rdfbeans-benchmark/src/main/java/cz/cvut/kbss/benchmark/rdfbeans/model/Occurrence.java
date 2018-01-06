package cz.cvut.kbss.benchmark.rdfbeans.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.cyberborean.rdfbeans.annotations.RDF;
import org.cyberborean.rdfbeans.annotations.RDFBean;
import org.cyberborean.rdfbeans.annotations.RDFSubject;

import java.util.Date;

@RDFBean(Vocabulary.s_c_Occurrence)
public class Occurrence extends Event implements cz.cvut.kbss.benchmark.model.Occurrence<Event> {

    private String name;

    @RDF(Vocabulary.s_p_label)
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Occurrence{" + name + " <" + getUri() + ">}";
    }
}
