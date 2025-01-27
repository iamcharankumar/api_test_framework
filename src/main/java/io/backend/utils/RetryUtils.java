package io.backend.utils;

import io.backend.exceptions.*;
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

    public RetryPolicy<Object> getRetryPolicyForAssertionError(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(AssertionError.class);
    }

    public RetryPolicy<Object> getRetryPolicyForZipposTestException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(ZipposTestException.class);
    }

    public RetryPolicy<Object> getRetryPolicyForReqresTestException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(ReqresTestException.class);
    }

    public RetryPolicy<Object> getRetryPolicyForRickAndMortyTestException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(RickAndMortyTestException.class);
    }

    public RetryPolicy<Object> getRetryPolicyForIfscCodeTestException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(IFSCCodeTestException.class);
    }

    public RetryPolicy<Object> getRetryPolicyForAutomationExerciseException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(AutomationExerciseException.class);
    }

    public RetryPolicy<Object> getRetryPolicyForDiscordException(int delayInSeconds, int maxRetries) {
        return getDefaultRetryPolicy(delayInSeconds, maxRetries).handle(DiscordException.class);
    }
}