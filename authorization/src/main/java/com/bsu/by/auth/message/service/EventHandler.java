package com.bsu.by.auth.message.service;

import com.bsu.by.auth.event.Event;
import com.bsu.by.auth.event.EventPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventHandler {
    private final EventService eventService;

    public void handle(Event<? extends EventPayload> event) {
        switch (event.getType()) {}
    }
}
