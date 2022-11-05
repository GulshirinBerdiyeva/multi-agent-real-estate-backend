package com.bsu.by.customer.agent.model;

public interface Versionable {
    Integer getVersion();

    void setVersion(Integer version);

    default void incrementVersion() {
        this.setVersion(this.getVersion() + 1);
    }
}
