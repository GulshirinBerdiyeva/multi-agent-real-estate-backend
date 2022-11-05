package com.bsu.by.data.agent.message.projector;

import com.bsu.by.data.agent.event.estate.NewEstateEvent;
import com.bsu.by.data.agent.model.Estate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstateProjector {
    private static final int VERSION = 1;

    public Estate project(NewEstateEvent event) {
        var payload = event.getPayload();
        return Estate.builder()
                .id(event.getEntityId())
                .apartment(payload.isApartment())
                .location(payload.getLocation())
                .area(payload.getArea())
                .description(payload.getDescription())
                .fileName(payload.getFileName())
                .version(VERSION)
                .build();
    }
}
