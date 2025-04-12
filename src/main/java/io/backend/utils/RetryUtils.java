package io.backend.utils;

import io.backend.exceptions.ApiTestException;
import io.backend.exceptions.DiscordException;
import net.jodah.failsafe.RetryPolicy;
import org.apache.http.NoHttpResponseException;

import java.net.ConnectException;
import java.net.SocketException;
import java.time.Duration;

public class RetryUtils {

    public RetryPolicy<Object> getDefaultRetryPolicy(int delayInSeconds, int maxRetries) {
        return new RetryPolicy<>()
                .handle(ConnectException.class)
                .handle(SocketException.class)
                .handle(NoHttpResponseException.class)
                .withDelay(Duration.ofSeconds(delayInSeconds))
                .withMaxRetries(maxRetries);
    }

    public RetryPolicy<Object> getRetryPolicyForZipposTestException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(ApiTestException.class);
    }

    public RetryPolicy<Object> getRetryPolicyForReqresTestException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(ApiTestException.class);
    }

    public RetryPolicy<Object> getRetryPolicyForRickAndMortyTestException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(ApiTestException.class);
    }

    public RetryPolicy<Object> getRetryPolicyForIfscCodeTestException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(ApiTestException.class);
    }

    public RetryPolicy<Object> getRetryPolicyForAutomationExerciseException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(ApiTestException.class);
    }

    public RetryPolicy<Object> getRetryPolicyForDiscordException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(DiscordException.class);
    }
}