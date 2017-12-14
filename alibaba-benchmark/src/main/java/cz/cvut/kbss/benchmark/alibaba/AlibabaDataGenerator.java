package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.alibaba.model.Occurrence;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.alibaba.model.Person;
import cz.cvut.kbss.benchmark.data.DataGenerator;

public class AlibabaDataGenerator extends DataGenerator {

    AlibabaDataGenerator() {
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
