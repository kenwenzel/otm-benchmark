package cz.cvut.kbss.benchmark.rdfbeans.data;

import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.rdfbeans.model.*;

public class RDFBeansDataGenerator extends DataGenerator<Person, OccurrenceReport> {

    public RDFBeansDataGenerator(int factor) {
        super(factor);
        generate();
    }

    @Override
    protected OccurrenceReport report() {
        final OccurrenceReport r = new OccurrenceReport();
        r.setUri(generateUri(OccurrenceReport.class).toString());
        return r;
    }

    @Override
    protected Occurrence occurrence() {
        final Occurrence occurrence = new Occurrence();
        occurrence.setUri(generateUri(Occurrence.class).toString());
        return occurrence;
    }

    @Override
    protected Event event() {
        final Event event = new Event();
        event.setUri(generateUri(Event.class).toString());
        return event;
    }

    @Override
    protected Resource resource() {
        final Resource resource = new Resource();
        resource.setUri(generateUri(Resource.class).toString());
        return resource;
    }

    @Override
    protected Person person() {
        final Person person = new Person();
        person.setUri(generateUri(Person.class).toString());
        return person;
    }
}
