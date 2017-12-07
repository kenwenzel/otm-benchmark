package cz.cvut.kbss.benchmark.alibaba.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.openrdf.annotations.Iri;

import java.net.URI;
import java.util.Date;

@Iri(Vocabulary.s_c_occurrence_report)
public class OccurrenceReport implements IOccurrenceReport {

    private URI uri;

    private Long fileNumber;

    private Occurrence occurrence;

    private Person author;

    private Date dateCreated;

    private Date lastModified;

    private Person lastModifiedBy;

    private Integer revision;

    private String summary;

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public Long getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(Long fileNumber) {
        this.fileNumber = fileNumber;
    }

    public Occurrence getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Occurrence occurrence) {
        this.occurrence = occurrence;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Person getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Person lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getSummary() {
        return summary;
    }

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
