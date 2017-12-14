package cz.cvut.kbss.benchmark.komma;

import cz.cvut.kbss.benchmark.komma.model.Occurrence;
import cz.cvut.kbss.benchmark.komma.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.komma.model.Person;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.komma.core.IEntityManager;
import net.enilink.komma.core.URI;
import net.enilink.komma.core.URIs;

import java.util.*;

public class KommaGenerator {

    private IEntityManager em;

    private Map<OccurrenceReport, URI> instances;

    public void setEm(IEntityManager em) {
        this.em = em;
    }

    private static final int COUNT = 300;

    private static final String SUMMARY =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor" +
                    " incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris" +
                    " nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum" +
                    " dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt" +
                    " mollit anim id est laborum.";

    private final Random random = new Random();

    private List<OccurrenceReport> reports;
    private List<Person> persons;

    public void generate() {
        this.instances = new IdentityHashMap<>();
        this.persons = generatePersons();
        this.reports = generateReports();
    }

    private List<OccurrenceReport> generateReports() {
        final List<OccurrenceReport> reports = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            OccurrenceReport r = report();
            r.setOccurrence(generateOccurrence());
            r.setAuthor(randomItem(persons));
            r.setFileNumber(random.nextLong());
            r.setDateCreated(new Date());
            r.setLastModified(new Date());
            r.setLastModifiedBy(randomItem(persons));
            r.setRevision(random.nextInt(COUNT));
            r.setSummary(SUMMARY + System.currentTimeMillis() + i);
            reports.add(r);
        }
        return reports;
    }

    private <T> T randomItem(List<T> items) {
        return items.get(random.nextInt(items.size()));
    }

    private Occurrence generateOccurrence() {
        final Occurrence occurrence = em
                .createNamed(URIs.createURI(generateUri(Occurrence.class).toString()), Occurrence.class);
        occurrence.setName("Occurrence" + random.nextInt());
        occurrence.setStartTime(new Date(System.currentTimeMillis() - 10000));
        occurrence.setEndTime(new Date());
        return occurrence;
    }

    private List<Person> generatePersons() {
        final List<Person> list = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            final Person p = em.createNamed(URIs.createURI(generateUri(Person.class).toString()), Person.class);
            p.setPassword("password-" + i);
            p.setFirstName("firstName" + i);
            p.setLastName("lastName" + i);
            p.setUsername("user" + i + "@krizik.felk.cvut.cz");
            list.add(p);
        }
        return list;
    }

    private java.net.URI generateUri(Class<?> type) {
        return java.net.URI.create(Vocabulary.BASE_URI + type.getSimpleName() + random.nextInt());
    }

    public List<OccurrenceReport> getReports() {
        return Collections.unmodifiableList(reports);
    }

    private OccurrenceReport report() {
        final URI uri = URIs.createURI(generateUri(OccurrenceReport.class).toString());
        final OccurrenceReport r = em.createNamed(uri, OccurrenceReport.class);
        instances.put(r, uri);
        return r;
    }

    public URI getUri(OccurrenceReport report) {
        return instances.get(report);
    }
}
