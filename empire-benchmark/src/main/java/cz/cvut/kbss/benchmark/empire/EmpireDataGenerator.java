package cz.cvut.kbss.benchmark.empire;

import com.clarkparsia.empire.SupportsRdfId;
import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.empire.model.Occurrence;
import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.empire.model.Person;
import cz.cvut.kbss.benchmark.empire.model.Resource;

public class EmpireDataGenerator extends DataGenerator {

    EmpireDataGenerator() {
        generate();
    }

    @Override
    protected OccurrenceReport report() {
        final OccurrenceReport r = new OccurrenceReport();
        r.setRdfId(new SupportsRdfId.URIKey(generateUri(OccurrenceReport.class)));
        return r;
    }

    @Override
    protected Occurrence occurrence() {
        final Occurrence occurrence = new Occurrence();
        occurrence.setRdfId(new SupportsRdfId.URIKey(generateUri(Occurrence.class)));
        return occurrence;
    }

    @Override
    protected Resource resource() {
        final Resource resource = new Resource();
        resource.setRdfId(new SupportsRdfId.URIKey(generateUri(Resource.class)));
        return resource;
    }

    @Override
    protected Person person() {
        final Person p = new Person();
        p.setRdfId(new SupportsRdfId.URIKey(generateUri(Person.class)));
        return p;
    }
}
