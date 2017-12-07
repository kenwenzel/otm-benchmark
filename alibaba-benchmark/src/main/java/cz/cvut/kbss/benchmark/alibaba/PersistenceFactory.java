package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.alibaba.model.Occurrence;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.alibaba.model.Person;
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
    private ObjectConnection connection;

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
        config.addConcept(Occurrence.class);
        config.addConcept(OccurrenceReport.class);
        config.addConcept(Person.class);
        this.objectRepository = factory.createRepository(config, repository);
        objectRepository.initialize();
    }

    ObjectConnection objectConnection() throws RepositoryException {
        if (connection == null) {
            this.connection = objectRepository.getConnection();
        }
        return connection;
    }

    void close() throws RepositoryException {
        connection.close();
        if (repository.isInitialized()) {
            repository.shutDown();
        }
    }
}
