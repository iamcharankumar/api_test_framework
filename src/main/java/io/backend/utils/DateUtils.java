package io.backend.utils;

import io.backend.exceptions.DateUtilsException;

import java.time.Duration;
import java.time.Instant;

public class DateUtils {
    public static Instant getCurrentInstantTimeStamp() {
        return Instant.now();
    }

    public static long getDurationBetweenTimeStamps(Instant startDate, Instant endDate) {
        if (startDate != null && endDate != null)
            return Duration.between(startDate, endDate).getSeconds();
        else
            throw new DateUtilsException("Calculation for Duration Between timestamps failed!");
    }
}