package io.backend.constants;

import io.backend.commons.RestResource;
import io.backend.utils.ConfigLoader;
import io.backend.utils.RetryUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiConstants {

    public static final ConfigLoader CONFIG_LOADER = ConfigLoader.getInstance();
    public static final RestResource REST_RESOURCE = RestResource.getInstance();
    public static final RetryUtils RETRY_UTILS = new RetryUtils();
}