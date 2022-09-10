package com.lastcivilization.userreadservice.domain.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String data) {
        super("Can not found user with data: %s".formatted(data));
    }
}
