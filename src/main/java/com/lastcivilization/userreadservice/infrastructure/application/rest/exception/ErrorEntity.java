package com.lastcivilization.userreadservice.infrastructure.application.rest.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

record ErrorEntity (String message, LocalDateTime dateTime) { }
