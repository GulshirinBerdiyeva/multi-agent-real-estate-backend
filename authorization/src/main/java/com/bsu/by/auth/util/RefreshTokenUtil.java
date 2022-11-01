package com.bsu.by.auth.util;

import com.bsu.by.auth.model.RefreshToken;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class RefreshTokenUtil {

    public RefreshToken createRefreshToken(String tokenHash, Instant expiration, String userId) {
        return RefreshToken.builder()
                .id(UUID.randomUUID().toString())
                .hash(tokenHash)
                .expiryDateTime(expiration)
                .userId(userId)
                .build();
    }
}