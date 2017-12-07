package cz.cvut.kbss.benchmark.alibaba;

import cz.cvut.kbss.benchmark.alibaba.model.Occurrence;
import cz.cvut.kbss.benchmark.alibaba.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.alibaba.model.Person;
import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.model.Vocabulary;

import java.net.URI;

public class AlibabaDataGenerator extends DataGenerator {

    @Override
    protected cz.cvut.kbss.benchmark.model.OccurrenceReport report() {
        final OccurrenceReport r = new OccurrenceReport();
        r.setUri(URI.create(Vocabulary.BASE_URI + OccurrenceReport.class.getSimpleName() + random.nextInt()));
        return r;
    }

    @Override
    protected cz.cvut.kbss.benchmark.model.Occurrence occurrence() {
        final Occurrence o = new Occurrence();
        o.setUri(URI.create(Vocabulary.BASE_URI + Occurrence.class.getSimpleName() + random.nextInt()));
        return o;
    }

    @Override
    protected cz.cvut.kbss.benchmark.model.Person person() {
        final Person p = new Person();
        p.setUri(URI.create(Vocabulary.BASE_URI + Person.class.getSimpleName() + random.nextInt()));
        return p;
    }
}
