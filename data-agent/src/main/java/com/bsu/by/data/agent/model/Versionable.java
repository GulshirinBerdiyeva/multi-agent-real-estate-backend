package com.bsu.by.data.agent.model;

public interface Versionable {
    Integer getVersion();

    void setVersion(Integer version);

    default void incrementVersion() {
        this.setVersion(this.getVersion() + 1);
    }
}
