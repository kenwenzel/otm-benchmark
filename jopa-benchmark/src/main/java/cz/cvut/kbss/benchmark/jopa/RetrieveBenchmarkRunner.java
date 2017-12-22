package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.jopa.util.JopaFinder;
import cz.cvut.kbss.benchmark.jopa.util.JopaSaver;
import cz.cvut.kbss.jopa.model.EntityManager;

public class RetrieveBenchmarkRunner extends JopaBenchmarkRunner {

    @Override
    public void setUp() {
        super.setUp();
        final EntityManager em = persistenceFactory.entityManager();
        persistData(new JopaSaver(em));
        em.close();
        System.gc();
        System.gc();
    }

    @Override
    public void execute() {
        final EntityManager em = persistenceFactory.entityManager();
        findAndVerifyAll(new JopaFinder(em));
    }
}
