package cz.cvut.kbss.benchmark.data;


import cz.cvut.kbss.benchmark.model.Occurrence;
import cz.cvut.kbss.benchmark.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.Person;

import java.util.*;

public abstract class DataGenerator {

    private static final int COUNT = 300;

    private static final String SUMMARY =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor" +
                    " incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris" +
                    " nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum" +
                    " dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt" +
                    " mollit anim id est laborum.";

    protected final Random random = new Random();

    private final List<OccurrenceReport> reports;
    private final List<Person> persons;

    public DataGenerator() {
        this.persons = generatePersons();
        this.reports = generateReports();
    }

    private List<OccurrenceReport> generateReports() {
        final List<OccurrenceReport> reports = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            final OccurrenceReport r = report();
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

    protected abstract OccurrenceReport report();

    private <T> T randomItem(List<T> items) {
        return items.get(random.nextInt(items.size()));
    }

    private Occurrence generateOccurrence() {
        final Occurrence occurrence = occurrence();
        occurrence.setName("Occurrence" + random.nextInt());
        occurrence.setStartTime(new Date(System.currentTimeMillis() - 10000));
        occurrence.setEndTime(new Date());
        return occurrence;
    }

    protected abstract Occurrence occurrence();

    private List<Person> generatePersons() {
        final List<Person> list = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            final Person p = person();
            p.setPassword("password-" + i);
            p.setFirstName("firstName" + i);
            p.setLastName("lastName" + i);
            p.setUsername("user" + i + "@krizik.felk.cvut.cz");
            list.add(p);
        }
        return list;
    }

    protected abstract Person person();

    public List<OccurrenceReport> getReports() {
        return Collections.unmodifiableList(reports);
    }
}
