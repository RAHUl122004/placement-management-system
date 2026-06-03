package com.placement.placement_management_system.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFound(ResourceNotFoundException ex) {
        return ex.getMessage();
    }
    @ExceptionHandler(DuplicateApplicationException.class)
    public String handleDuplicateApplication(DuplicateApplicationException ex) {
        return ex.getMessage();
}
}
