package cz.cvut.kbss.benchmark.alibaba.model;

import cz.cvut.kbss.benchmark.model.Person;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.openrdf.annotations.Iri;

@Iri(Vocabulary.s_c_Person)
public interface IPerson extends Person {
    @Iri(Vocabulary.s_p_firstName)
    @Override
    String getFirstName();

    @Iri(Vocabulary.s_p_firstName)
    @Override
    void setFirstName(String firstName);

    @Iri(Vocabulary.s_p_lastName)
    @Override
    String getLastName();

    @Iri(Vocabulary.s_p_lastName)
    @Override
    void setLastName(String lastName);

    @Iri(Vocabulary.s_p_accountName)
    @Override
    String getUsername();

    @Iri(Vocabulary.s_p_accountName)
    @Override
    void setUsername(String username);

    @Iri(Vocabulary.s_p_password)
    @Override
    String getPassword();

    @Iri(Vocabulary.s_p_password)
    @Override
    void setPassword(String password);
}
