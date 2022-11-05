package com.bsu.by.customer.agent.repository;

import com.bsu.by.customer.agent.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateRepository extends JpaRepository<Estate, String> {
}
