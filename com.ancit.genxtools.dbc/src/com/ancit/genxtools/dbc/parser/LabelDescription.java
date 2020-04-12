package com.ancit.genxtools.dbc.parser;

import java.util.Set;

import com.ancit.genxtools.dbc.model.Label;

class LabelDescription {

    private long id;
    private String signalName;
    private Set<Label> labels;
    private boolean extended;

    public boolean isExtended() {
        return extended;
    }

    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }
}