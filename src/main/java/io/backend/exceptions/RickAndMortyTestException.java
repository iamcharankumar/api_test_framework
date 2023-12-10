package io.backend.exceptions;

public class RickAndMortyTestException extends RuntimeException {
    public RickAndMortyTestException(String errorMessage) {
        super(errorMessage);
    }
}