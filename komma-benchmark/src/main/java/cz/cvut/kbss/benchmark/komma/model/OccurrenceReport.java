package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static cz.cvut.kbss.benchmark.komma.util.BenchmarkUtil.datatypeFactory;

@Iri(Vocabulary.s_c_occurrence_report)
public interface OccurrenceReport {

    @Iri(Vocabulary.s_p_has_file_number)
    Long getFileNumber();

    void setFileNumber(Long fileNumber);

    @Iri(Vocabulary.s_p_documents)
    Occurrence getOccurrence();

    void setOccurrence(Occurrence occurrence);

    @Iri(Vocabulary.s_p_has_author)
    Person getAuthor();

    void setAuthor(Person author);

    default Date getDateCreated() {
        return getCreated().toGregorianCalendar().getTime();
    }

    default void setDateCreated(Date dateCreated) {
        final GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(dateCreated);
        setCreated(datatypeFactory().newXMLGregorianCalendar(gCal));
    }

    @Iri(Vocabulary.s_p_created)
    XMLGregorianCalendar getCreated();

    void setCreated(XMLGregorianCalendar created);

    default Date getLastModified() {
        return getLastMod().toGregorianCalendar().getTime();
    }

    default void setLastModified(Date lastModified) {
        final GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(lastModified);
        setLastMod(datatypeFactory().newXMLGregorianCalendar(gCal));
    }

    @Iri(Vocabulary.s_p_modified)
    XMLGregorianCalendar getLastMod();

    void setLastMod(XMLGregorianCalendar calendar);

    @Iri(Vocabulary.s_p_has_last_editor)
    Person getLastModifiedBy();

    void setLastModifiedBy(Person lastModifiedBy);

    @Iri(Vocabulary.s_p_has_revision)
    Integer getRevision();

    void setRevision(Integer revision);

    @Iri(Vocabulary.s_p_description)
    String getSummary();

    void setSummary(String summary);
}
