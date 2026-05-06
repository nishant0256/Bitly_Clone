package com.example.demo.urlshortner.exception;

public class DuplicateShortCodeException extends RuntimeException {

    public DuplicateShortCodeException(String message) {
        super(message);
    }
}
