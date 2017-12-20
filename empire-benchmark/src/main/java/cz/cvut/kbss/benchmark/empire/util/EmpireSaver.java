package cz.cvut.kbss.benchmark.empire.util;

import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.empire.model.Person;
import cz.cvut.kbss.benchmark.util.Saver;

import javax.persistence.EntityManager;
import java.util.Collection;

public class EmpireSaver implements Saver<Person, OccurrenceReport> {

    private final EntityManager em;

    public EmpireSaver(EntityManager em) {
        this.em = em;
    }

    @Override
    public void begin() {
        // Do nothing, transactions in Empire do not work the usual way
    }

    @Override
    public void commit() {
        // Do nothing, transactions in Empire do not work the usual way
    }

    @Override
    public void persistAll(Collection<Person> persons) {
        persons.forEach(em::persist);
    }

    @Override
    public void persist(OccurrenceReport report) {
        em.persist(report);
    }
}
