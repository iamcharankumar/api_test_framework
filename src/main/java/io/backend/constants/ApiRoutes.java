package io.backend.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiRoutes {
    public static final String GET_POSTAL_CODE_INFO = ApiConstants.CONFIG_LOADER.getZipposHost() + "/";
    public static final String POST_CREATE_USER = ApiConstants.CONFIG_LOADER.getReqresHost() + "/api/users";
    public static final String GET_RICK_AND_MORTY_CHARACTER = ApiConstants.CONFIG_LOADER.getRickAndMortyHost() + "/api/character/";
    public static final String IFSC_CODE_DETAILS = ApiConstants.CONFIG_LOADER.getIfscCodeHost() + "/";
    public static final String GET_ALL_PRODUCTS_LIST = ApiConstants.CONFIG_LOADER.getAutomationExerciseHost() + "/api/productsList";

    // DISCORD API
    public static final String DISCORD_WEBHOOK = ApiConstants.CONFIG_LOADER.getDiscordHost() + "/api/webhooks/";
}
