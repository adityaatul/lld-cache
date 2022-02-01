package com.adityaatul.exception;

public class InvalidElementException extends RuntimeException{
    public InvalidElementException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InvalidElementException";
    }
}
