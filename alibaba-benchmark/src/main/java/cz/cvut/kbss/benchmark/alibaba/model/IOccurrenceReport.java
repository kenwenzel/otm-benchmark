package cz.cvut.kbss.benchmark.alibaba.model;

import cz.cvut.kbss.benchmark.model.OccurrenceReport;
import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.openrdf.annotations.Iri;

import java.util.Date;
import java.util.Set;

@Iri(Vocabulary.s_c_occurrence_report)
public interface IOccurrenceReport extends OccurrenceReport<Occurrence, Person, Resource>, HasUri {

    @Iri(Vocabulary.s_p_has_file_number)
    @Override
    Long getFileNumber();

    @Iri(Vocabulary.s_p_has_file_number)
    @Override
    void setFileNumber(Long fileNumber);

    @Iri(Vocabulary.s_p_documents)
    @Override
    Occurrence getOccurrence();

    @Iri(Vocabulary.s_p_documents)
    @Override
    void setOccurrence(Occurrence occurrence);

    @Iri(Vocabulary.s_p_has_severity_assessment)
    @Override
    Integer getSeverityAssessment();

    @Override
    void setSeverityAssessment(Integer severityAssessment);

    @Iri(Vocabulary.s_p_has_author)
    @Override
    Person getAuthor();

    @Iri(Vocabulary.s_p_has_author)
    @Override
    void setAuthor(Person author);

    @Iri(Vocabulary.s_p_created)
    @Override
    Date getDateCreated();

    @Iri(Vocabulary.s_p_created)
    @Override
    void setDateCreated(Date dateCreated);

    @Iri(Vocabulary.s_p_modified)
    @Override
    Date getLastModified();

    @Iri(Vocabulary.s_p_modified)
    @Override
    void setLastModified(Date lastModified);

    @Iri(Vocabulary.s_p_has_last_editor)
    @Override
    Person getLastModifiedBy();

    @Iri(Vocabulary.s_p_has_last_editor)
    @Override
    void setLastModifiedBy(Person lastModifiedBy);

    @Iri(Vocabulary.s_p_references)
    @Override
    Set<Resource> getAttachments();

    @Iri(Vocabulary.s_p_references)
    @Override
    void setAttachments(Set<Resource> attachments);

    @Iri(Vocabulary.s_p_has_revision)
    @Override
    Integer getRevision();

    @Iri(Vocabulary.s_p_has_revision)
    @Override
    void setRevision(Integer revision);

    @Iri(Vocabulary.s_p_description)
    @Override
    String getSummary();

    @Iri(Vocabulary.s_p_description)
    @Override
    void setSummary(String summary);
}
