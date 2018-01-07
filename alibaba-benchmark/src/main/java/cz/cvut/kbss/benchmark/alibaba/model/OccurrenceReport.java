package cz.cvut.kbss.benchmark.alibaba.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.openrdf.annotations.Iri;

import java.net.URI;
import java.util.Date;
import java.util.Set;

@Iri(Vocabulary.s_c_occurrence_report)
public class OccurrenceReport implements IOccurrenceReport {

    private URI uri;

    private String key;

    private Long fileNumber;

    private Occurrence occurrence;

    private Integer severityAssessment;

    private Person author;

    private Date dateCreated;

    private Date lastModified;

    private Person lastModifiedBy;

    private Integer revision;

    private Set<Resource> attachments;

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
                "fileNumber=" + fileNumber +
                ", revision=" + revision +
                ", occurrence=" + occurrence +
                '}';
    }
}
