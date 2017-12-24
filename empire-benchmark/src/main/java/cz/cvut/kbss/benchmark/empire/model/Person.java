package cz.cvut.kbss.benchmark.empire.model;

import com.clarkparsia.empire.SupportsRdfId;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;
import com.clarkparsia.empire.annotation.SupportsRdfIdImpl;
import cz.cvut.kbss.benchmark.model.Vocabulary;

import javax.persistence.Entity;
import java.util.Objects;
import java.util.Set;

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

    @RdfProperty(Vocabulary.s_p_contact)
    private Set<String> contacts;

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
    public Set<String> getContacts() {
        return contacts;
    }

    @Override
    public void setContacts(Set<String> contacts) {
        this.contacts = contacts;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(mIdSupport, person.mIdSupport) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(username, person.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mIdSupport, firstName, lastName, username);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " <" + mIdSupport + ">";
    }
}
