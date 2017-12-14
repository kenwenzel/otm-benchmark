package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static cz.cvut.kbss.benchmark.komma.util.BenchmarkUtil.datatypeFactory;

@Iri(Vocabulary.s_c_occurrence_report)
public interface OccurrenceReport extends cz.cvut.kbss.benchmark.model.OccurrenceReport<Occurrence, Person> {

    @Iri(Vocabulary.s_p_has_file_number)
    @Override
    Long getFileNumber();

    @Iri(Vocabulary.s_p_documents)
    @Override
    Occurrence getOccurrence();

    @Iri(Vocabulary.s_p_has_author)
    @Override
    Person getAuthor();

    @Override
    default Date getDateCreated() {
        return getCreated().toGregorianCalendar().getTime();
    }

    @Override
    default void setDateCreated(Date dateCreated) {
        final GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(dateCreated);
        setCreated(datatypeFactory().newXMLGregorianCalendar(gCal));
    }

    @Iri(Vocabulary.s_p_created)
    XMLGregorianCalendar getCreated();

    void setCreated(XMLGregorianCalendar created);

    @Override
    default Date getLastModified() {
        return getLastMod().toGregorianCalendar().getTime();
    }

    @Override
    default void setLastModified(Date lastModified) {
        final GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(lastModified);
        setLastMod(datatypeFactory().newXMLGregorianCalendar(gCal));
    }

    @Iri(Vocabulary.s_p_modified)
    XMLGregorianCalendar getLastMod();

    void setLastMod(XMLGregorianCalendar calendar);

    @Iri(Vocabulary.s_p_has_last_editor)
    @Override
    Person getLastModifiedBy();

    @Iri(Vocabulary.s_p_has_revision)
    @Override
    Integer getRevision();

    @Iri(Vocabulary.s_p_description)
    @Override
    String getSummary();
}
