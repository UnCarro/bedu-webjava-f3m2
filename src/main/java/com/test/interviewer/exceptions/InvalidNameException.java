package com.test.interviewer.exceptions;

public class InvalidNameException extends RuntimeException {

    public InvalidNameException() {
        super();  // Call the superclass constructor
    }

    public InvalidNameException(String message) {
        super(message);  // Call the superclass constructor with a custom message
    }
    
}
