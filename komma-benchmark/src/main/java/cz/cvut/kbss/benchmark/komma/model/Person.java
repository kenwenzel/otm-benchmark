package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

@Iri(Vocabulary.s_c_Person)
public interface Person extends cz.cvut.kbss.benchmark.model.Person {

    @Iri(Vocabulary.s_p_firstName)
    @Override
    String getFirstName();

    @Override
    void setFirstName(String firstName);

    @Iri(Vocabulary.s_p_lastName)
    @Override
    String getLastName();

    @Override
    void setLastName(String lastName);

    @Iri(Vocabulary.s_p_accountName)
    @Override
    String getUsername();

    @Override
    void setUsername(String username);

    @Iri(Vocabulary.s_p_password)
    @Override
    String getPassword();

    @Override
    void setPassword(String password);
}