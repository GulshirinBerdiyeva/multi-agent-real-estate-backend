package com.bsu.by.seller.agent.exception.badrequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FileNotProvidedException extends ResponseStatusException {
    public FileNotProvidedException() {
        super(HttpStatus.BAD_REQUEST, "File not provided");
    }
}
