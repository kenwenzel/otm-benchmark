package cz.cvut.kbss.benchmark.rdfbeans.model;

import cz.cvut.kbss.benchmark.model.Vocabulary;
import org.cyberborean.rdfbeans.annotations.RDF;
import org.cyberborean.rdfbeans.annotations.RDFBean;
import org.cyberborean.rdfbeans.annotations.RDFSubject;

import java.util.Date;
import java.util.Set;

@RDFBean(Vocabulary.s_c_occurrence_report)
public class OccurrenceReport implements cz.cvut.kbss.benchmark.model.OccurrenceReport<Occurrence, Person, Resource> {

    private String uri;

    private Long fileNumber;

    private Occurrence occurrence;

    private Person author;

    private Date dateCreated;

    private Date lastModified;

    private Person lastModifiedBy;

    private Set<Resource> attachments;

    private Integer revision;

    private String summary;

    @RDFSubject
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @RDF(Vocabulary.s_p_has_file_number)
    @Override
    public Long getFileNumber() {
        return fileNumber;
    }

    @Override
    public void setFileNumber(Long fileNumber) {
        this.fileNumber = fileNumber;
    }

    @RDF(Vocabulary.s_p_documents)
    @Override
    public Occurrence getOccurrence() {
        return occurrence;
    }

    @Override
    public void setOccurrence(Occurrence occurrence) {
        this.occurrence = occurrence;
    }

    @RDF(Vocabulary.s_p_has_author)
    @Override
    public Person getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(Person author) {
        this.author = author;
    }

    @RDF(Vocabulary.s_p_created)
    @Override
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @RDF(Vocabulary.s_p_modified)
    @Override
    public Date getLastModified() {
        return lastModified;
    }

    @Override
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @RDF(Vocabulary.s_p_has_last_editor)
    @Override
    public Person getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(Person lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @RDF(Vocabulary.s_p_references)
    @Override
    public Set<Resource> getAttachments() {
        return attachments;
    }

    @Override
    public void setAttachments(Set<Resource> attachments) {
        this.attachments = attachments;
    }

    @RDF(Vocabulary.s_p_has_revision)
    @Override
    public Integer getRevision() {
        return revision;
    }

    @Override
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    @RDF(Vocabulary.s_p_description)
    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }
}
