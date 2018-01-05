package cz.cvut.kbss.benchmark.empire.model;

import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;
import cz.cvut.kbss.benchmark.model.Vocabulary;

import javax.persistence.Entity;

@Entity
@RdfsClass(Vocabulary.s_c_Occurrence)
public class Occurrence extends Event implements cz.cvut.kbss.benchmark.model.Occurrence<Event> {

    @RdfProperty(Vocabulary.s_p_label)
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
        return "Occurrence{" + name + " <" + getId() + ">}";
    }
}
