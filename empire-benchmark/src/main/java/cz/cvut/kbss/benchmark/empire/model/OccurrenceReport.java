package cz.cvut.kbss.benchmark.empire.model;

import com.clarkparsia.empire.SupportsRdfId;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;
import com.clarkparsia.empire.annotation.SupportsRdfIdImpl;
import cz.cvut.kbss.benchmark.model.Vocabulary;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@RdfsClass(Vocabulary.s_c_occurrence_report)
public class OccurrenceReport
        implements SupportsRdfId, cz.cvut.kbss.benchmark.model.OccurrenceReport<Occurrence, Person, Resource> {

    private SupportsRdfId mIdSupport = new SupportsRdfIdImpl();

    @RdfProperty(Vocabulary.s_p_has_file_number)
    private Long fileNumber;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @RdfProperty(Vocabulary.s_p_documents)
    private Occurrence occurrence;

    @ManyToOne(fetch = FetchType.EAGER)
    @RdfProperty(Vocabulary.s_p_has_author)
    private Person author;

    @RdfProperty(Vocabulary.s_p_created)
    private Date dateCreated;

    @RdfProperty(Vocabulary.s_p_modified)
    private Date lastModified;

    @ManyToOne(fetch = FetchType.EAGER)
    @RdfProperty(Vocabulary.s_p_has_last_editor)
    private Person lastModifiedBy;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @RdfProperty(Vocabulary.s_p_references)
    private Set<Resource> attachments;

    @RdfProperty(Vocabulary.s_p_has_revision)
    private Integer revision;

    @RdfProperty(Vocabulary.s_p_description)
    private String summary;

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
                "id=" + mIdSupport +
                ", fileNumber=" + fileNumber +
                ", revision=" + revision +
                ", occurrence=" + occurrence +
                '}';
    }

    @Override
    public SupportsRdfId.RdfKey getRdfId() {
        return mIdSupport.getRdfId();
    }

    @Override
    public void setRdfId(SupportsRdfId.RdfKey rdfKey) {
        mIdSupport.setRdfId(rdfKey);
    }
}
