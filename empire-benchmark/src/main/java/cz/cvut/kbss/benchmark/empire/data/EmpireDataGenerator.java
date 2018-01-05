package cz.cvut.kbss.benchmark.empire.data;

import com.clarkparsia.empire.SupportsRdfId;
import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.empire.model.*;

public class EmpireDataGenerator extends DataGenerator<Person, OccurrenceReport> {

    public EmpireDataGenerator(int factor) {
        super(factor);
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
    protected Event event() {
        final Event event = new Event();
        event.setRdfId(new SupportsRdfId.URIKey(generateUri(Event.class)));
        return event;
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
