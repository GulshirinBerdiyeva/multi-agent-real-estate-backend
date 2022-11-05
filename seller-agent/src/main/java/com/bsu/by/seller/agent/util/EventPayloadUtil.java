package com.bsu.by.seller.agent.util;

import com.bsu.by.seller.agent.dto.request.EstateDto;
import com.bsu.by.seller.agent.event.estate.NewEstateEvent;
import org.springframework.stereotype.Component;

@Component
public class EventPayloadUtil {
    public NewEstateEvent.Payload createNewEstateEventPayload(EstateDto estateDto, String fileName, String extension) {
        return NewEstateEvent.Payload.builder()
                .apartment(estateDto.isApartment())
                .location(estateDto.getLocation())
                .area(estateDto.getArea())
                .description(estateDto.getDescription())
                .fileName(String.format("%s.%s", fileName, extension))
                .build();
    }
}
