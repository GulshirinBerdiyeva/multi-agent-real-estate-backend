package com.bsu.by.customer.agent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FileReadException extends ResponseStatusException {
    public FileReadException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, String.format("File not processed. %s", message));
    }
}
