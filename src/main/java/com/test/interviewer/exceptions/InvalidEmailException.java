package com.test.interviewer.exceptions;

public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException() {
        super();  // Call the superclass constructor
    }

    public InvalidEmailException(String message) {
        super(message);  // Call the superclass constructor with a custom message
    }
   
}
