package com.bsu.by.webapigateway.exception.unauthorized;

import com.bsu.by.webapigateway.exception.ExceptionMessageType;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UnauthorizedException extends ResponseStatusException {
    public UnauthorizedException() {
        super(HttpStatus.UNAUTHORIZED , ExceptionMessageType.UNAUTHORIZED.name());
    }
}
