package cz.cvut.kbss.benchmark.alibaba.model;

import java.net.URI;
import java.util.Set;

public class Person implements IPerson {

    private URI uri;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Set<String> contacts;

    @Override
    public URI getUri() {
        return uri;
    }

    @Override
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
        return firstName + " " + lastName;
    }
}
