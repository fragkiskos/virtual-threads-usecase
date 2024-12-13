package com.frank.virtualthreads.proxyservice.business;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class DateExceptionHandler {

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<String> handleDateTimeParseException(DateTimeParseException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
