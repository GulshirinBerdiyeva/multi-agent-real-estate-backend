package com.bsu.by.data.agent.message.service;

import com.bsu.by.data.agent.event.estate.NewEstateEvent;
import com.bsu.by.data.agent.message.projector.EstateProjector;
import com.bsu.by.data.agent.model.Estate;
import com.bsu.by.data.agent.repository.EstateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventService {
    private final EstateProjector estateProjector;
    private final EstateRepository estateRepository;

    @Transactional
    public void handle(NewEstateEvent event) {
        Estate estate = estateProjector.project(event);
        estateRepository.save(estate);
        log.info("'new-estate' with id='{}' saved after consuming event", estate.getId());
    }
}
