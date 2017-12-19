package cz.cvut.kbss.benchmark.model;

import java.io.Serializable;
import java.util.Set;

public interface Person extends Serializable {

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    Set<String> getContacts();

    void setContacts(Set<String> contacts);
}
