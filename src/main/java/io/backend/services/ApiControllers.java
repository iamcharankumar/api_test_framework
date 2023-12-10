package io.backend.services;

import io.backend.commons.HttpStatuses;
import io.backend.entities.request.CreateUsersRequest;
import io.backend.entities.response.CreateUserResponse;
import io.backend.entities.response.PostalCodeDetailsResponse;
import io.backend.entities.response.RickAndMortyResponse;
import io.backend.utils.RetryUtils;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.Failsafe;

@Slf4j
public class ApiControllers {

    ApiClients apiClients;

    public ApiControllers() {
        this.apiClients = new ApiClients();
    }

    public PostalCodeDetailsResponse getPostalCodeDetailsResponse(String country, String pinCode) {
        return Failsafe.with(new RetryUtils().getRetryPolicyForZipposTestException(2, 3)).get(() -> {
            Response zipposPostalCodeResponse = apiClients.getPostalCodeResponse(country, pinCode);
            if (zipposPostalCodeResponse.getStatusCode() != HttpStatuses.OK.getCode())
                log.error("Retrying for the Zippos Postal Code. Please stay with us...");
            return apiClients.deserialize(zipposPostalCodeResponse, PostalCodeDetailsResponse.class);
        });
    }

    public CreateUserResponse getCreateUserResponse(CreateUsersRequest createUsersRequest) {
        return Failsafe.with(new RetryUtils().getRetryPolicyForReqresTestException(2, 3)).get(() -> {
            Response createUserResponse = apiClients.createUserResponse(createUsersRequest);
            if (createUserResponse.getStatusCode() != HttpStatuses.OK.getCode())
                log.error("Retrying for the Reqres Create User. Please stay with us...");
            return apiClients.deserialize(createUserResponse, CreateUserResponse.class);
        });
    }


    public RickAndMortyResponse getRickAndMortyResponse(int characterId) {
        return Failsafe.with(new RetryUtils().getRetryPolicyForRickAndMortyTestException(2, 3)).get(() -> {
            Response rickAndMortyCharacterResponse = apiClients.getRickAndMortyCharacterResponse(characterId);
            if (rickAndMortyCharacterResponse.getStatusCode() != HttpStatuses.OK.getCode())
                log.error("Retrying for the Rick And Morty Character. Please stay with us...");
            return apiClients.deserialize(rickAndMortyCharacterResponse, RickAndMortyResponse.class);
        });
    }
}