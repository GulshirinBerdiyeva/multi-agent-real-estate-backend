package com.bsu.by.seller.agent.message.sender;

import com.bsu.by.seller.agent.event.Event;
import com.bsu.by.seller.agent.event.EventPayload;
import com.bsu.by.seller.agent.message.EventSender;
import com.bsu.by.seller.agent.repository.EventRepository;
import com.bsu.by.seller.agent.util.EventUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventSenderKafkaImpl implements EventSender {
    @Value("${kafka.topic.new-estate}")
    private String newEstateTopic;
    private final KafkaTemplate<Long, Event<? extends EventPayload>> kafkaTemplate;
    private final EventRepository eventRepository;

    @Override
    public void send(Event<? extends EventPayload> event) {
        kafkaTemplate.send(newEstateTopic, EventUtil.uuidStringToLong(event.getEntityId()), event);
        log.info("kafka send 'new-estate' event with entity-id {}", event.getEntityId());
        eventRepository.save(event);
        kafkaTemplate.flush();
    }
}
