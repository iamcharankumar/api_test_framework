package io.backend.exceptions;

public class ApiTestException extends RuntimeException {

    public ApiTestException(String errorMessage) {
        super(errorMessage);
    }
}