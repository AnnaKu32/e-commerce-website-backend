package com.project.backend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long username) {
        super("Could not find user with username: " + username);
    }
}
