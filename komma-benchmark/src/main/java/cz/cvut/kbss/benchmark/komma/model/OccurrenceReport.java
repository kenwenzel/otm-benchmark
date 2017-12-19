package cz.cvut.kbss.benchmark.komma.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import net.enilink.composition.annotations.Iri;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Set;

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

    @Iri(Vocabulary.s_p_created)
    XMLGregorianCalendar getDateCreated();

    void setDateCreated(XMLGregorianCalendar created);

    @Iri(Vocabulary.s_p_modified)
    XMLGregorianCalendar getLastModified();

    void setLastModified(XMLGregorianCalendar calendar);

    @Iri(Vocabulary.s_p_has_last_editor)
    Person getLastModifiedBy();

    void setLastModifiedBy(Person lastModifiedBy);

    @Iri(Vocabulary.s_p_references)
    Set<Resource> getAttachments();

    void setAttachments(Set<Resource> attachments);

    @Iri(Vocabulary.s_p_has_revision)
    Integer getRevision();

    void setRevision(Integer revision);

    @Iri(Vocabulary.s_p_description)
    String getSummary();

    void setSummary(String summary);
}
