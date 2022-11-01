package com.bsu.by.auth.message;

import com.bsu.by.auth.event.Event;
import com.bsu.by.auth.event.EventPayload;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
    <T extends Event<? extends EventPayload>> void consume(@Payload T event);
}
