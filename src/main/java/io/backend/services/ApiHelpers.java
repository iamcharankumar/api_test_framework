package io.backend.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
