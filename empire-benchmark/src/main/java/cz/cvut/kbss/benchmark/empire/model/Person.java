package cz.cvut.kbss.benchmark.empire.model;

import com.clarkparsia.empire.SupportsRdfId;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;
import com.clarkparsia.empire.annotation.SupportsRdfIdImpl;
import cz.cvut.kbss.benchmark.model.Vocabulary;

import javax.persistence.Entity;

@Entity
@RdfsClass(Vocabulary.s_c_Person)
public class Person implements SupportsRdfId, cz.cvut.kbss.benchmark.model.Person {

    private SupportsRdfId mIdSupport = new SupportsRdfIdImpl();

    @RdfProperty(Vocabulary.s_p_firstName)
    private String firstName;

    @RdfProperty(Vocabulary.s_p_lastName)
    private String lastName;

    @RdfProperty(Vocabulary.s_p_accountName)
    private String username;

    @RdfProperty(Vocabulary.s_p_password)
    private String password;

    public Person() {
    }

    public Person(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " <" + mIdSupport + ">";
    }

    @Override
    public RdfKey getRdfId() {
        return mIdSupport.getRdfId();
    }

    @Override
    public void setRdfId(RdfKey rdfKey) {
        mIdSupport.setRdfId(rdfKey);
    }
}
