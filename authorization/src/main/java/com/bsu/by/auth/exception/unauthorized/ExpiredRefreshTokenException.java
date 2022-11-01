package com.bsu.by.auth.exception.unauthorized;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExpiredRefreshTokenException extends ResponseStatusException {
    public ExpiredRefreshTokenException() {
        super(HttpStatus.UNAUTHORIZED, "Refresh token is expired");
    }
}
