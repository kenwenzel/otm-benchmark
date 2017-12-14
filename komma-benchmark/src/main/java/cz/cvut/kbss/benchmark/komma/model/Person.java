package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

@Iri(Vocabulary.s_c_Person)
public interface Person extends cz.cvut.kbss.benchmark.model.Person {

    @Iri(Vocabulary.s_p_firstName)
    @Override
    String getFirstName();

    @Iri(Vocabulary.s_p_lastName)
    @Override
    String getLastName();

    @Iri(Vocabulary.s_p_accountName)
    @Override
    String getUsername();

    @Iri(Vocabulary.s_p_password)
    @Override
    String getPassword();
}
