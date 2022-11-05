package com.bsu.by.data.agent.event.estate;

import com.bsu.by.data.agent.event.Event;
import com.bsu.by.data.agent.event.EventPayload;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "NEW_ESTATE_EVENT")
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class NewEstateEvent extends Event<NewEstateEvent.Payload> {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    @Builder
    public static class Payload extends EventPayload {
        private boolean apartment;
        private String location;
        private double area;
        private String description;
        private String fileName;
    }
}
