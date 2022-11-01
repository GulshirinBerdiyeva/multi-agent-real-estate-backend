package com.bsu.by.webapigateway.exception.unauthorized;

import com.bsu.by.webapigateway.exception.ExceptionMessageType;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidTokenException extends ResponseStatusException {
    public InvalidTokenException() {
        super(HttpStatus.UNAUTHORIZED, ExceptionMessageType.INVALID_TOKEN.name());
    }
}
