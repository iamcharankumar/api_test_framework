package io.backend.utils;

import io.backend.exceptions.DateUtilsException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.Instant;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {
    public static Instant getCurrentInstantTimeStamp() {
        return Instant.now();
    }

    public static long getDurationBetweenTimeStamps(Instant startDate, Instant endDate) {
        if (startDate == null || endDate == null || startDate.isAfter(endDate))
            throw new DateUtilsException("Calculation for Duration Between timestamps failed!");
        return Duration.between(startDate, endDate).getSeconds();
    }
}