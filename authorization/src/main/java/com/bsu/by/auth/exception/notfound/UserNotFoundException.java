package com.bsu.by.auth.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {
    public UserNotFoundException(String userId) {
        super(HttpStatus.NOT_FOUND, String.format("User with id='%s' not found", userId));
    }

    public UserNotFoundException(String email, boolean isEmail) {
        super(HttpStatus.NOT_FOUND, String.format("User with email='%s' not found", email));
    }
}
