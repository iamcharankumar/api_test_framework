package io.backend.services.rest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiHelpers {

    private static ApiControllers apiControllers;

    public static ApiControllers getApiControllers() {
        if (apiControllers == null) {
            log.info("Setting up the Api Controllers...");
            apiControllers = new ApiControllers();
        }
        return apiControllers;
    }
}
