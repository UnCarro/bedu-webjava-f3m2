package com.test.interviewer.exceptions;

public class InvalidLastNameException extends Exception {
    public InvalidLastNameException() {
        super();  // Call the superclass constructor
    }

    public InvalidLastNameException(String message) {
        super(message);  // Call the superclass constructor with a custom message
    }
    
}
