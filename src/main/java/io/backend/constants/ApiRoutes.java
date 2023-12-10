package io.backend.constants;

import io.backend.utils.ConfigLoader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiRoutes {
    public static final String GET_POSTAL_CODE_INFO = ConfigLoader.getInstance().getZipposHost() + "/";
    public static final String POST_CREATE_USER = ConfigLoader.getInstance().getReqresHost() + "/api/users";
    public static final String GET_RICK_AND_MORTY_CHARACTER = ConfigLoader.getInstance().getRickAndMortyHost() + "/api/character/";
}
