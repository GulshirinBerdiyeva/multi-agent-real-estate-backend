package com.bsu.by.webapigateway.exception.unauthorized;

import com.bsu.by.webapigateway.exception.ExceptionMessageType;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExpiredTokenException extends ResponseStatusException {
    public ExpiredTokenException() {
        super(HttpStatus.UNAUTHORIZED , ExceptionMessageType.EXPIRED_TOKEN.name());
    }
}
