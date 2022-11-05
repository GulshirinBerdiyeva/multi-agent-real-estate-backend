package com.bsu.by.customer.agent.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EstateNotFoundException extends ResponseStatusException {
    public EstateNotFoundException(String id) {
        super(HttpStatus.NOT_FOUND, String.format("Estate with id='%s' not found", id));
    }
}
