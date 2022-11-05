package com.bsu.by.data.agent.message.consumer;

import com.bsu.by.data.agent.event.Event;
import com.bsu.by.data.agent.event.EventPayload;
import com.bsu.by.data.agent.message.EventConsumer;
import com.bsu.by.data.agent.message.service.EventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewEstateEventConsumer implements EventConsumer {
    private final EventHandler eventHandler;

    @KafkaListener(topics = "${kafka.topic.new-estate}")
    @Override
    public <T extends Event<? extends EventPayload>> void consume(@Payload T event) {
        eventHandler.handle(event);
    }
}
