package com.lastcivilization.userreadservice.infrastructure.application.rest.exception;

import java.time.LocalDateTime;

record ErrorEntity (String message, LocalDateTime dateTime) {
    ErrorEntity(String message){
        this(message, LocalDateTime.now());
    }
}
