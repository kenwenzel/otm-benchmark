package cz.cvut.kbss.benchmark.komma;

import cz.cvut.kbss.benchmark.komma.model.Occurrence;
import cz.cvut.kbss.benchmark.komma.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.komma.model.Person;
import cz.cvut.kbss.benchmark.komma.model.Resource;
import cz.cvut.kbss.benchmark.komma.util.BenchmarkUtil;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.benchmark.util.Constants;
import net.enilink.komma.core.IEntityManager;
import net.enilink.komma.core.URI;
import net.enilink.komma.core.URIs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static cz.cvut.kbss.benchmark.util.Constants.ITEM_COUNT;

public class KommaGenerator {

    private final int itemCount;

    private IEntityManager em;

    private Map<Object, URI> instances;

    public KommaGenerator(int factor) {
        this.itemCount = ITEM_COUNT * factor;
    }

    public void setEm(IEntityManager em) {
        this.em = em;
    }

    private final Random random = new Random();

    private List<OccurrenceReport> reports;
    private List<Person> persons;

    public void persistData() {
        this.instances = new IdentityHashMap<>();
        em.getTransaction().begin();
        this.persons = generatePersons();
        this.reports = generateReports();
        em.getTransaction().commit();
    }

    public void persistPersons() {
        em.getTransaction().begin();
        this.persons = generatePersons();
        em.getTransaction().commit();
    }

    public void executeCreate() {
        this.instances = new IdentityHashMap<>();
        this.reports = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            em.getTransaction().begin();
            final OccurrenceReport report = report();
            reports.add(report);
            em.getTransaction().commit();
        }
    }

    public void executeBatchCreate() {
        this.instances = new IdentityHashMap<>();
        this.reports = new ArrayList<>(itemCount);
        em.getTransaction().begin();
        this.reports = generateReports();
        em.getTransaction().commit();
    }

    private List<OccurrenceReport> generateReports() {
        final List<OccurrenceReport> reports = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            final OccurrenceReport r = report();
            reports.add(r);
        }
        return reports;
    }

    private OccurrenceReport report() {
        final URI uri = URIs.createURI(generateUri(OccurrenceReport.class).toString());
        final OccurrenceReport r = em.createNamed(uri, OccurrenceReport.class);
        r.setOccurrence(generateOccurrence());
        r.setSeverityAssessment(random.nextInt(Constants.MAX_SEVERITY));
        r.setAuthor(randomItem(persons));
        r.setFileNumber(random.nextLong());
        r.setDateCreated(BenchmarkUtil.datatypeFactory().newXMLGregorianCalendar(new GregorianCalendar()));
        r.setLastModified(BenchmarkUtil.datatypeFactory().newXMLGregorianCalendar(new GregorianCalendar()));
        r.setLastModifiedBy(randomItem(persons));
        r.setAttachments(generateAttachments());
        r.setRevision(random.nextInt(ITEM_COUNT));
        r.setSummary(Constants.SUMMARY + System.currentTimeMillis());
        instances.put(r, uri);
        return r;
    }

    private Set<Resource> generateAttachments() {
        return IntStream.range(0, 3).mapToObj(i -> generateAttachment()).collect(Collectors.toSet());
    }

    public Resource generateAttachment() {
        final URI uri = URIs.createURI(generateUri(Resource.class).toString());
        final Resource attachment = em.createNamed(uri, Resource.class);
        attachment.setIdentifier("resource" + random.nextInt() + ".doc");
        attachment.setDescription("This resource was attached to further document the reported occurrence.");
        instances.put(attachment, uri);
        return attachment;
    }

    public <T> T randomItem(List<T> items) {
        return items.get(random.nextInt(items.size()));
    }

    private Occurrence generateOccurrence() {
        final URI uri = URIs.createURI(generateUri(Occurrence.class).toString());
        final Occurrence occurrence = em.createNamed(uri, Occurrence.class);
        occurrence.setName("Occurrence" + random.nextInt());
        occurrence.setStartTime(new Date(System.currentTimeMillis() - 10000));
        occurrence.setEndTime(new Date());
        instances.put(occurrence, uri);
        return occurrence;
    }

    private List<Person> generatePersons() {
        final List<Person> list = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            final Person p = em.createNamed(URIs.createURI(generateUri(Person.class).toString()), Person.class);
            p.setPassword("password-" + i);
            p.setFirstName("firstName" + i);
            p.setLastName("lastName" + i);
            p.setUsername("user" + i);
            p.setContacts(IntStream.range(0, 5)
                                   .mapToObj(j -> String.format("%s_%d@kbss.felk.cvut.cz", p.getUsername(), j))
                                   .collect(Collectors.toSet()));
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

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }

    public URI getUri(Object report) {
        return instances.get(report);
    }
}
