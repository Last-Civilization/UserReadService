package com.lastcivilization.userreadservice.infrastructure.application.rest.exception;

import com.lastcivilization.userreadservice.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorEntity handleUserNotFoundException(UserNotFoundException exception){
        return new ErrorEntity(exception.getMessage());
    }

}
