package com.test.interviewer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestException(InvalidNameException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(InvalidLastNameException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestException(InvalidLastNameException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestException(InvalidEmailException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    
}
