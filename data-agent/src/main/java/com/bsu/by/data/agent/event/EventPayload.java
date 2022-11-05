package com.bsu.by.data.agent.event;

import com.bsu.by.data.agent.event.estate.NewEstateEvent;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NewEstateEvent.Payload.class, name = "NEW_ESTATE_EVENT")
})
@NoArgsConstructor
public class EventPayload {
}
