package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.alibaba.model.*;
import cz.cvut.kbss.benchmark.util.Config;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.config.RepositoryConfigException;
import org.openrdf.repository.http.HTTPRepository;
import org.openrdf.repository.object.ObjectConnection;
import org.openrdf.repository.object.ObjectRepository;
import org.openrdf.repository.object.config.ObjectRepositoryConfig;
import org.openrdf.repository.object.config.ObjectRepositoryFactory;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFWriterRegistry;
import org.openrdf.rio.binary.BinaryRDFWriterFactory;
import org.openrdf.sail.memory.MemoryStore;

class PersistenceFactory {

    private final Repository repository;
    private final ObjectRepository objectRepository;

    PersistenceFactory() throws RepositoryConfigException, RepositoryException {
        // When running in a jar, Sesame for some reason does not register appropriate RDF writer factories
        RDFWriterRegistry.getInstance().add(new BinaryRDFWriterFactory());
        if (Config.getRepoUrl().isPresent()) {
            this.repository = new HTTPRepository(Config.getRepoUrl().get());
        } else {
            this.repository = new SailRepository(new MemoryStore());
        }
        repository.initialize();

        final ObjectRepositoryFactory factory = new ObjectRepositoryFactory();
        final ObjectRepositoryConfig config = factory.getConfig();
        config.addConcept(Event.class);
        config.addConcept(Occurrence.class);
        config.addConcept(OccurrenceReport.class);
        config.addConcept(Person.class);
        config.addConcept(Resource.class);
        this.objectRepository = factory.createRepository(config, repository);
        objectRepository.initialize();
    }

    ObjectConnection objectConnection() throws RepositoryException {
        return objectRepository.getConnection();
    }

    void close() throws RepositoryException {
        if (repository.isInitialized()) {
            repository.shutDown();
        }
    }
}
