package com.example.semesterwork.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MissingServletRequestParameterExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleMissingServletRequestParameter(MissingServletRequestParameterException ex) {
        String errorMessage = "Required parameter '" + ex.getParameterName() + "' is missing.";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
