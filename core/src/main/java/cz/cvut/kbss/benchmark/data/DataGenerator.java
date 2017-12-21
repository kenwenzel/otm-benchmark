package cz.cvut.kbss.benchmark.data;


import cz.cvut.kbss.benchmark.model.*;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static cz.cvut.kbss.benchmark.util.Constants.ITEM_COUNT;
import static cz.cvut.kbss.benchmark.util.Constants.SUMMARY;

public abstract class DataGenerator<P extends Person, R extends OccurrenceReport> {

    protected final Random random = new Random();

    private List<R> reports;
    private List<P> persons;

    public void generate() {
        this.persons = generatePersons();
        this.reports = generateReports();
    }

    protected List<R> generateReports() {
        final List<R> reports = new ArrayList<>();
        for (int i = 0; i < ITEM_COUNT; i++) {
            final R r = report();
            r.setOccurrence(generateOccurrence());
            r.setAuthor(randomItem(persons));
            r.setFileNumber(random.nextLong());
            r.setDateCreated(currentTime());
            r.setLastModified(currentTime());
            r.setLastModifiedBy(randomItem(persons));
            r.setAttachments(generateAttachments());
            r.setRevision(random.nextInt(ITEM_COUNT));
            r.setSummary(SUMMARY + System.currentTimeMillis() + i);
            reports.add(r);
        }
        return reports;
    }

    /**
     * Gets current date rounded to whole seconds. This is because some libraries have trouble working with times in milliseconds.
     *
     * @return Current date and time rounded to whole seconds
     */
    private Date currentTime() {
        final long time = (System.currentTimeMillis() / 1000) * 1000;
        return new Date(time);
    }

    protected abstract R report();

    public <T> T randomItem(List<T> items) {
        return items.get(random.nextInt(items.size()));
    }

    protected Occurrence generateOccurrence() {
        final Occurrence occurrence = occurrence();
        occurrence.setName("Occurrence" + random.nextInt());
        occurrence.setStartTime(new Date(System.currentTimeMillis() - 10000));
        occurrence.setEndTime(new Date());
        return occurrence;
    }

    protected abstract Occurrence occurrence();

    protected Set<Resource> generateAttachments() {
        return IntStream.range(0, 3).mapToObj(i -> generateAttachment()).collect(Collectors.toSet());
    }

    public Resource generateAttachment() {
        final Resource attachment = resource();
        attachment.setIdentifier("resource" + random.nextInt() + ".doc");
        attachment.setDescription("This resource was attached to further document the reported occurrence.");
        return attachment;
    }

    protected abstract Resource resource();

    protected List<P> generatePersons() {
        final List<P> list = new ArrayList<>();
        for (int i = 0; i < ITEM_COUNT; i++) {
            final P p = person();
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

    protected abstract P person();

    protected URI generateUri(Class<?> type) {
        return URI.create(Vocabulary.BASE_URI + type.getSimpleName() + random.nextInt());
    }

    public List<P> getPersons() {
        return Collections.unmodifiableList(persons);
    }

    public List<R> getReports() {
        return Collections.unmodifiableList(reports);
    }
}
