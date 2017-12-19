package cz.cvut.kbss.benchmark.jopa.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.jopa.model.annotations.Id;
import cz.cvut.kbss.jopa.model.annotations.OWLClass;
import cz.cvut.kbss.jopa.model.annotations.OWLDataProperty;

import java.net.URI;
import java.util.Set;

@OWLClass(iri = Vocabulary.s_c_Person)
public class Person implements cz.cvut.kbss.benchmark.model.Person {

    @Id
    private URI uri;

    @OWLDataProperty(iri = Vocabulary.s_p_firstName)
    private String firstName;

    @OWLDataProperty(iri = Vocabulary.s_p_lastName)
    private String lastName;

    @OWLDataProperty(iri = Vocabulary.s_p_accountName)
    private String username;

    @OWLDataProperty(iri = Vocabulary.s_p_password)
    private String password;

    @OWLDataProperty(iri = Vocabulary.s_p_contact)
    private Set<String> contacts;

    public Person() {
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
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
    public Set<String> getContacts() {
        return contacts;
    }

    @Override
    public void setContacts(Set<String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " <" + uri + ">";
    }
}
