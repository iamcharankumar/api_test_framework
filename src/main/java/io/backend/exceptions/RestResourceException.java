package io.backend.exceptions;

public class RestResourceException extends RuntimeException {
    public RestResourceException(String errorMessage) {
        super(errorMessage);
    }
}