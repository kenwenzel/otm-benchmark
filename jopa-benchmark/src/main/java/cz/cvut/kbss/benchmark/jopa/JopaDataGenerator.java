package cz.cvut.kbss.benchmark.jopa;

import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.jopa.model.Occurrence;
import cz.cvut.kbss.benchmark.jopa.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.jopa.model.Person;

public class JopaDataGenerator extends DataGenerator {

    JopaDataGenerator() {
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
    protected Person person() {
        final Person p = new Person();
        p.setUri(generateUri(Person.class));
        return p;
    }
}
