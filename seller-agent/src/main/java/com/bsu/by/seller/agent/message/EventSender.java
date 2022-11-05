package com.bsu.by.seller.agent.message;

import com.bsu.by.seller.agent.event.Event;
import com.bsu.by.seller.agent.event.EventPayload;

public interface EventSender {
    void send(Event<? extends EventPayload> event);
}
