package com.bsu.by.auth.exception.conflict;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RefreshTokenWithNoSessionException extends ResponseStatusException {
    public RefreshTokenWithNoSessionException() {
        super(HttpStatus.CONFLICT, "There isn't associated session with this refresh token");
    }
}
