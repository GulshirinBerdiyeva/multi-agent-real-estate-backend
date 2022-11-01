package com.bsu.by.auth.util;

import com.bsu.by.auth.event.Event;
import com.bsu.by.auth.event.EventPayload;
import com.bsu.by.auth.event.EventType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class EventUtil {
    @Value("${spring.application.name}")
    private String context;

    public <T extends EventPayload, S extends Event<T>> void populateEventFields(S event, EventType type,
                                                                                 String entityId, Integer version,
                                                                                 String authorId, T payload,
                                                                                 String parentId) {
        event.setId(UUID.randomUUID().toString());
        event.setType(type);
        event.setEntityId(entityId);
        event.setAuthorId(authorId);
        event.setContext(context);
        event.setDateTime(Instant.now());
        event.setVersion(version);
        event.setParentId(parentId);
        event.setPayload(payload);
    }

    public static Long uuidStringToLong(String uuid) {
        return UUID.fromString(uuid).getMostSignificantBits() & Long.MAX_VALUE;
    }
}
