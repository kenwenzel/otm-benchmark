package cz.cvut.kbss.benchmark.jopa.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import cz.cvut.kbss.jopa.model.annotations.*;

import java.net.URI;
import java.util.Date;
import java.util.Set;

@OWLClass(iri = Vocabulary.s_c_occurrence_report)
public class OccurrenceReport implements cz.cvut.kbss.benchmark.model.OccurrenceReport<Occurrence, Person, Resource> {

    @Id
    private URI uri;

    @OWLDataProperty(iri = Vocabulary.s_p_has_key)
    private String key;

    @OWLDataProperty(iri = Vocabulary.s_p_has_file_number)
    private Long fileNumber;

    @OWLObjectProperty(iri = Vocabulary.s_p_documents, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Occurrence occurrence;

    @OWLDataProperty(iri = Vocabulary.s_p_has_severity_assessment)
    private Integer severityAssessment;

    @OWLObjectProperty(iri = Vocabulary.s_p_has_author, fetch = FetchType.EAGER)
    private Person author;

    @OWLDataProperty(iri = Vocabulary.s_p_created)
    private Date dateCreated;

    @OWLDataProperty(iri = Vocabulary.s_p_modified)
    private Date lastModified;

    @OWLObjectProperty(iri = Vocabulary.s_p_has_last_editor, fetch = FetchType.EAGER)
    private Person lastModifiedBy;

    @OWLObjectProperty(iri = Vocabulary.s_p_references, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Resource> attachments;

    @OWLDataProperty(iri = Vocabulary.s_p_has_revision)
    private Integer revision;

    @OWLDataProperty(iri = Vocabulary.s_p_description)
    private String summary;

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getId() {
        return uri.toString();
    }

    @Override
    public Long getFileNumber() {
        return fileNumber;
    }

    @Override
    public void setFileNumber(Long fileNumber) {
        this.fileNumber = fileNumber;
    }

    @Override
    public Occurrence getOccurrence() {
        return occurrence;
    }

    @Override
    public void setOccurrence(Occurrence occurrence) {
        this.occurrence = occurrence;
    }

    @Override
    public Integer getSeverityAssessment() {
        return severityAssessment;
    }

    @Override
    public void setSeverityAssessment(Integer severityAssessment) {
        this.severityAssessment = severityAssessment;
    }

    @Override
    public Person getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public Date getLastModified() {
        return lastModified;
    }

    @Override
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public Person getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(Person lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public Set<Resource> getAttachments() {
        return attachments;
    }

    @Override
    public void setAttachments(Set<Resource> attachments) {
        this.attachments = attachments;
    }

    @Override
    public Integer getRevision() {
        return revision;
    }

    @Override
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "OccurrenceReport{" +
                "uri=" + uri +
                ", fileNumber=" + fileNumber +
                ", revision=" + revision +
                ", occurrence=" + occurrence +
                '}';
    }
}
