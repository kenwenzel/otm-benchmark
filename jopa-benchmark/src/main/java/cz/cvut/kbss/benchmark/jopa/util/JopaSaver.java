package cz.cvut.kbss.benchmark.jopa.util;

import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.jopa.model.Person;
import cz.cvut.kbss.benchmark.util.Saver;
import cz.cvut.kbss.jopa.model.EntityManager;

import java.util.Collection;

public class JopaSaver implements Saver<Person, OccurrenceReport> {

    private final EntityManager em;

    public JopaSaver(EntityManager em) {
        this.em = em;
    }

    @Override
    public void begin() {
        em.getTransaction().begin();
    }

    @Override
    public void commit() {
        em.getTransaction().commit();
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
