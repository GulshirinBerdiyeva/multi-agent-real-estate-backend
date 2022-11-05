package com.bsu.by.data.agent.repository;

import com.bsu.by.data.agent.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateRepository extends JpaRepository<Estate, String> {
}
