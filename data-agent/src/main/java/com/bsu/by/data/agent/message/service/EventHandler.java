package com.bsu.by.data.agent.message.service;

import com.bsu.by.data.agent.event.Event;
import com.bsu.by.data.agent.event.EventPayload;
import com.bsu.by.data.agent.event.EventType;
import com.bsu.by.data.agent.event.estate.NewEstateEvent;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.util.Objects;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventHandler {
    private final EventService eventService;

    public void handle(Event<? extends EventPayload> event) {
        if (Objects.areEqual(EventType.NEW_ESTATE_EVENT, event.getType())) {
            eventService.handle((NewEstateEvent) event);
        }
    }
}
