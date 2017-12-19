package cz.cvut.kbss.benchmark.alibaba.model;

import java.net.URI;
import java.util.Date;


public class Occurrence implements IOccurrence {

    private URI uri;

    private String name;

    private Date startTime;

    private Date endTime;

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Occurrence{" + name + "}";
    }
}
