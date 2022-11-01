package com.bsu.by.auth.repository;

import com.bsu.by.auth.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    boolean existsByHash(String hash);
    void deleteAllByExpiryDateTimeBefore(Instant currentDateTime);
    void deleteByHash(String hash);
    void deleteByUserId(String userId);
}
