package cz.cvut.kbss.benchmark.rdfbeans.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.cyberborean.rdfbeans.annotations.RDF;
import org.cyberborean.rdfbeans.annotations.RDFBean;
import org.cyberborean.rdfbeans.annotations.RDFSubject;

import java.util.Objects;
import java.util.Set;

@RDFBean(Vocabulary.s_c_Person)
public class Person implements cz.cvut.kbss.benchmark.model.Person {

    private String uri;

    private String key;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Set<String> contacts;

    @RDFSubject
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @RDF(Vocabulary.s_p_has_key)
    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getId() {
        return uri;
    }

    @RDF(Vocabulary.s_p_firstName)
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @RDF(Vocabulary.s_p_lastName)
    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @RDF(Vocabulary.s_p_accountName)
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @RDF(Vocabulary.s_p_password)
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @RDF(Vocabulary.s_p_contact)
    @Override
    public Set<String> getContacts() {
        return contacts;
    }

    @Override
    public void setContacts(Set<String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(uri, person.uri) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(username, person.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, firstName, lastName, username);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
