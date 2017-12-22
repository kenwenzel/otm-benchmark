package cz.cvut.kbss.benchmark.empire;

import cz.cvut.kbss.benchmark.empire.util.EmpireFinder;
import cz.cvut.kbss.benchmark.empire.util.EmpireSaver;

import javax.persistence.EntityManager;

public class RetrieveBenchmarkRunner extends EmpireBenchmarkRunner {


    @Override
    public void setUp() {
        super.setUp();
        final EntityManager em = persistenceFactory.entityManager();
        persistData(new EmpireSaver(em));
        em.clear();
        System.gc();
        System.gc();
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        findAndVerifyAll(new EmpireFinder(em));
    }
}
