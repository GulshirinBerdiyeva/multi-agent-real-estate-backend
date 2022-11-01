package com.bsu.by.auth.message;

import com.bsu.by.auth.event.Event;
import com.bsu.by.auth.event.EventPayload;

public interface EventSender {
    void send(Event<? extends EventPayload> event);
}
