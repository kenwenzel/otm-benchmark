package cz.cvut.kbss.benchmark.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public interface OccurrenceReport<O extends Occurrence, P extends Person, R extends Resource>
        extends Serializable, HasIdentifier {

    Long getFileNumber();

    void setFileNumber(Long fileNumber);

    Occurrence getOccurrence();

    void setOccurrence(O occurrence);

    Integer getSeverityAssessment();

    void setSeverityAssessment(Integer severityAssessment);

    Person getAuthor();

    void setAuthor(P author);

    Date getDateCreated();

    void setDateCreated(Date dateCreated);

    Date getLastModified();

    void setLastModified(Date lastModified);

    Person getLastModifiedBy();

    void setLastModifiedBy(P lastModifiedBy);

    Set<R> getAttachments();

    void setAttachments(Set<R> attachments);

    Integer getRevision();

    void setRevision(Integer revision);

    String getSummary();

    void setSummary(String summary);
}
