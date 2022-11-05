package com.bsu.by.data.agent.repository;

import com.bsu.by.data.agent.event.Event;
import com.bsu.by.data.agent.event.EventPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event<? extends EventPayload>, String> {
}
