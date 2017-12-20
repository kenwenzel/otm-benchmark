package cz.cvut.kbss.benchmark.rdfbeans.util;

import cz.cvut.kbss.benchmark.BenchmarkException;
import cz.cvut.kbss.benchmark.rdfbeans.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.rdfbeans.model.Person;
import cz.cvut.kbss.benchmark.util.Saver;
import org.cyberborean.rdfbeans.RDFBeanManager;
import org.cyberborean.rdfbeans.exceptions.RDFBeanException;

import java.util.Collection;

public class RdfBeansSaver implements Saver<Person, OccurrenceReport> {

    private final RDFBeanManager beanManager;

    public RdfBeansSaver(RDFBeanManager beanManager) {
        this.beanManager = beanManager;
    }

    @Override
    public void begin() {
        beanManager.getRepositoryConnection().begin();
    }

    @Override
    public void commit() {
        beanManager.getRepositoryConnection().commit();
    }

    @Override
    public void persistAll(Collection<Person> persons) {
        try {
            for (Person p : persons) {
                beanManager.add(p);
            }
        } catch (RDFBeanException e) {
            throw new BenchmarkException(e);
        }
    }

    @Override
    public void persist(OccurrenceReport report) {
        try {
            beanManager.add(report);
        } catch (RDFBeanException e) {
            throw new BenchmarkException(e);
        }
    }
}
