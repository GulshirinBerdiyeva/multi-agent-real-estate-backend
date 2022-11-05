package com.bsu.by.data.agent.util;

import com.bsu.by.data.agent.event.Event;
import com.bsu.by.data.agent.event.EventPayload;
import com.bsu.by.data.agent.event.EventType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class EventUtil {
    @Value(value = "${spring.application.name}")
    private String context;

    public <T extends EventPayload, S extends Event<T>> void populateEventFields(S event, EventType type,
                                                                                 String entityId, Integer version,
                                                                                 T payload) {
        event.setId(UUID.randomUUID().toString());
        event.setType(type);
        event.setContext(context);
        event.setEntityId(entityId);
        event.setVersion(version);
        event.setPayload(payload);
        event.setDateTime(Instant.now());
    }
}
