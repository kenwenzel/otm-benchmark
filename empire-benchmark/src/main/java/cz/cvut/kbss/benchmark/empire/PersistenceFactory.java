package cz.cvut.kbss.benchmark.empire;

import com.clarkparsia.empire.Empire;
import com.clarkparsia.empire.sesame.OpenRdfEmpireModule;
import org.openrdf.rio.RDFWriterRegistry;
import org.openrdf.rio.binary.BinaryRDFWriterFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class PersistenceFactory {

    // Rely on Empire's configuration file naming convention
    static String CONFIG_FILE = "empire.configuration";

    private final EntityManagerFactory emf;
    /*
    In Empire, the EntityManager is the manager of the repository connection, so e.g. when two entity managers
    are created, they connect to two different memory stores.
    Accessing remote store probably shouldn't cause such problems. But the behavior is certainly not correct w.r.t. JPA.
     */
    private final EntityManager em;

    PersistenceFactory() {
        // When running in a jar, Sesame for some reason does not register appropriate RDF writer factories
        RDFWriterRegistry.getInstance().add(new BinaryRDFWriterFactory());
        Empire.init(new OpenRdfEmpireModule());
        this.emf = Persistence.createEntityManagerFactory("empire");
        this.em = emf.createEntityManager();
    }

    EntityManager entityManager() {
        return em;
    }

    void close() {
        if (em.isOpen()) {
            em.close();
        }
        emf.close();
    }
}
