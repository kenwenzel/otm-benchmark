package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.util.Config;
import cz.cvut.kbss.jopa.Persistence;
import cz.cvut.kbss.jopa.model.EntityManager;
import cz.cvut.kbss.jopa.model.EntityManagerFactory;
import cz.cvut.kbss.jopa.model.JOPAPersistenceProvider;
import cz.cvut.kbss.ontodriver.config.OntoDriverProperties;
import cz.cvut.kbss.ontodriver.sesame.SesameDataSource;
import cz.cvut.kbss.ontodriver.sesame.config.SesameOntoDriverProperties;
import org.eclipse.rdf4j.rio.RDFWriterRegistry;
import org.eclipse.rdf4j.rio.binary.BinaryRDFWriterFactory;

import java.util.HashMap;
import java.util.Map;

import static cz.cvut.kbss.jopa.model.JOPAPersistenceProperties.*;

class PersistenceFactory {

    private final EntityManagerFactory emf;

    PersistenceFactory() {
        // When running in a jar, RDF4J for some reason does not register appropriate RDF writer factories
        RDFWriterRegistry.getInstance().add(new BinaryRDFWriterFactory());
        final Map<String, String> properties = new HashMap<>();
        if (Config.getRepoUrl().isPresent()) {
            properties.put(ONTOLOGY_PHYSICAL_URI_KEY, Config.getRepoUrl().get());
        } else {
            properties.put(ONTOLOGY_PHYSICAL_URI_KEY, "BenchmarkStorage");
            properties.put(SesameOntoDriverProperties.SESAME_USE_VOLATILE_STORAGE, Boolean.TRUE.toString());
        }
        properties.put(DATA_SOURCE_CLASS, SesameDataSource.class.getCanonicalName());
        properties.put(OntoDriverProperties.ONTOLOGY_LANGUAGE, "en");
        properties.put(SCAN_PACKAGE, "cz.cvut.kbss.benchmark.jopa.model");
        properties.put(JPA_PERSISTENCE_PROVIDER, JOPAPersistenceProvider.class.getName());
        properties.put(CACHE_ENABLED, Boolean.FALSE.toString());
        this.emf = Persistence.createEntityManagerFactory("benchmarkPU", properties);
    }

    EntityManager entityManager() {
        return emf.createEntityManager();
    }

    void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
