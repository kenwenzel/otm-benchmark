package cz.cvut.kbss.benchmark.empire;

import com.clarkparsia.empire.SupportsRdfId;
import cz.cvut.kbss.benchmark.data.DataGenerator;
import cz.cvut.kbss.benchmark.empire.model.Occurrence;
import cz.cvut.kbss.benchmark.empire.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.empire.model.Person;
import cz.cvut.kbss.benchmark.model.Vocabulary;

import java.net.URI;

public class EmpireDataGenerator extends DataGenerator {

    @Override
    protected cz.cvut.kbss.benchmark.model.OccurrenceReport report() {
        final OccurrenceReport r = new OccurrenceReport();
        r.setRdfId(new SupportsRdfId.URIKey(URI.create(
                Vocabulary.BASE_URI + OccurrenceReport.class.getSimpleName() + random.nextInt())));
        return r;
    }

    @Override
    protected cz.cvut.kbss.benchmark.model.Occurrence occurrence() {
        final Occurrence occurrence = new Occurrence();
        occurrence.setRdfId(new SupportsRdfId.URIKey(
                URI.create(Vocabulary.BASE_URI + Occurrence.class.getSimpleName() + random.nextInt())));
        return occurrence;
    }

    @Override
    protected cz.cvut.kbss.benchmark.model.Person person() {
        final Person p = new Person();
        p.setRdfId(new SupportsRdfId.URIKey(
                URI.create(Vocabulary.BASE_URI + Person.class.getSimpleName() + random.nextInt())));
        return p;
    }
}
