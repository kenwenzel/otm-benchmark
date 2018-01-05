package cz.cvut.kbss.benchmark.jopa.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.jopa.model.annotations.OWLAnnotationProperty;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;

@OWLClass(iri = Vocabulary.s_c_Occurrence)
public class Occurrence extends Event implements cz.cvut.kbss.benchmark.model.Occurrence<Event> {

    @OWLAnnotationProperty(iri = Vocabulary.s_p_label)
    private String name;

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
