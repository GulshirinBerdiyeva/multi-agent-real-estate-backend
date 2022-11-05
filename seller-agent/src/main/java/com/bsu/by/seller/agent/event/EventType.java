package com.bsu.by.seller.agent.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EventType {
    NEW_ESTATE_EVENT(AssociatedObject.ESTATE);

    @Getter
    private final AssociatedObject associatedObject;
    public enum AssociatedObject {
        ESTATE
    }
}
