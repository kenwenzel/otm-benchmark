package cz.cvut.kbss.benchmark.model;

import java.io.Serializable;
import java.util.Date;

public interface OccurrenceReport<O extends Occurrence, P extends Person> extends Serializable {

    Long getFileNumber();

    void setFileNumber(Long fileNumber);

    Occurrence getOccurrence();

    void setOccurrence(O occurrence);

    Person getAuthor();

    void setAuthor(P author);

    Date getDateCreated();

    void setDateCreated(Date dateCreated);

    Date getLastModified();

    void setLastModified(Date lastModified);

    Person getLastModifiedBy();

    void setLastModifiedBy(P lastModifiedBy);

    Integer getRevision();

    void setRevision(Integer revision);

    String getSummary();

    void setSummary(String summary);
}
