package cz.cvut.kbss.benchmark.komma;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cz.cvut.kbss.benchmark.komma.model.Occurrence;
import cz.cvut.kbss.benchmark.komma.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.komma.model.Person;
import cz.cvut.kbss.benchmark.komma.model.Resource;
import cz.cvut.kbss.benchmark.komma.util.BenchmarkModule;
import cz.cvut.kbss.benchmark.util.Config;
import net.enilink.komma.core.IEntityManager;
import net.enilink.komma.core.IEntityManagerFactory;
import net.enilink.komma.core.KommaModule;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFWriterRegistry;
import org.eclipse.rdf4j.rio.binary.BinaryRDFWriterFactory;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

public class PersistenceFactory {

    private final Repository repository;
    private final IEntityManagerFactory emf;

    PersistenceFactory() {
        // When running in a jar, Sesame for some reason does not register appropriate RDF writer factories
        RDFWriterRegistry.getInstance().add(new BinaryRDFWriterFactory());
        if (Config.getRepoUrl().isPresent()) {
            this.repository = new HTTPRepository(Config.getRepoUrl().get());
        } else {
            this.repository = new SailRepository(new MemoryStore());
        }
        repository.initialize();
        Injector injector = Guice.createInjector(new BenchmarkModule(repository, new KommaModule() {
            {
                addConcept(Person.class);
                addConcept(Occurrence.class);
                addConcept(OccurrenceReport.class);
                addConcept(Resource.class);
            }
        }));
        this.emf = injector.getInstance(IEntityManagerFactory.class);
    }

    public IEntityManager entityManager() {
        return emf.get();
    }

    public void close() {
        emf.close();
        if (repository.isInitialized()) {
            repository.shutDown();
        }
    }
}
