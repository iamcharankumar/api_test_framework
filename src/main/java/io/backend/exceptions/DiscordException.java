package io.backend.exceptions;

public class DiscordException extends RuntimeException {
    public DiscordException(String errorMessage) {
        super(errorMessage);
    }
}