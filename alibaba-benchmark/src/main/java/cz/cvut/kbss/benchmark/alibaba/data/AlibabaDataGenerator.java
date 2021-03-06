package cz.cvut.kbss.benchmark.alibaba.data;

import cz.cvut.kbss.benchmark.alibaba.model.*;
import cz.cvut.kbss.benchmark.data.DataGenerator;

public class AlibabaDataGenerator extends DataGenerator<Person, OccurrenceReport> {

    public AlibabaDataGenerator(float factor) {
        super(factor);
        generate();
    }

    @Override
    protected OccurrenceReport report() {
        final OccurrenceReport r = new OccurrenceReport();
        r.setUri(generateUri(OccurrenceReport.class));
        return r;
    }

    @Override
    protected Occurrence occurrence() {
        final Occurrence o = new Occurrence();
        o.setUri(generateUri(Occurrence.class));
        return o;
    }

    @Override
    protected Event event() {
        final Event event = new Event();
        event.setUri(generateUri(Event.class));
        return event;
    }

    @Override
    protected Resource resource() {
        final Resource r = new Resource();
        r.setUri(generateUri(Resource.class));
        return r;
    }

    @Override
    protected Person person() {
        final Person p = new Person();
        p.setUri(generateUri(Person.class));
        return p;
    }
}
