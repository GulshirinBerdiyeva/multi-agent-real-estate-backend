package com.bsu.by.customer.agent.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FileNotFoundException extends ResponseStatusException {
    public FileNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}
