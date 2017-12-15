package cz.cvut.kbss.benchmark.rdfbeans;

import cz.cvut.kbss.benchmark.util.Config;
import org.cyberborean.rdfbeans.RDFBeanManager;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.config.RepositoryConfigException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFWriterRegistry;
import org.eclipse.rdf4j.rio.binary.BinaryRDFWriterFactory;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

public class PersistenceFactory {

    private final Repository repository;
    private RepositoryConnection connection;

    PersistenceFactory() throws RepositoryConfigException, RepositoryException {
        // When running in a jar, RDF4J for some reason does not register appropriate RDF writer factories
        RDFWriterRegistry.getInstance().add(new BinaryRDFWriterFactory());
        if (Config.getRepoUrl().isPresent()) {
            this.repository = new HTTPRepository(Config.getRepoUrl().get());
        } else {
            this.repository = new SailRepository(new MemoryStore());
        }
        repository.initialize();
        this.connection = repository.getConnection();
    }

    RDFBeanManager beanManager() {
        return new RDFBeanManager(connection);
    }

    void close() throws RepositoryException {
        if (repository.isInitialized()) {
            connection.close();
            repository.shutDown();
        }
    }
}
