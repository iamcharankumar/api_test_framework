package io.backend.services.rest;

import io.backend.commons.HttpStatuses;
import io.backend.constants.ApiConstants;
import io.backend.entities.response.CreateUserResponse;
import io.backend.entities.response.IfscCodeDetailsResponse;
import io.backend.entities.response.PostalCodeDetailsResponse;
import io.backend.entities.response.RickAndMortyResponse;
import io.backend.entities.response.automationexercise.GetAllProductListResponse;
import io.backend.exceptions.*;
import io.backend.utils.RetryUtils;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.Failsafe;

@Slf4j
public class ApiControllers {

    private final ApiClients API_CLIENTS;

    public ApiControllers() {
        this.API_CLIENTS = new ApiClients();
    }

    public PostalCodeDetailsResponse getPostalCodeDetailsResponse(String country, String pinCode) {
        return Failsafe.with(new RetryUtils().getRetryPolicyForZipposTestException(2, 3)).get(() -> {
            Response zipposPostalCodeResponse = API_CLIENTS.getPostalCodeResponse(country, pinCode);
            if (zipposPostalCodeResponse.getStatusCode() != HttpStatuses.OK.getCode()) {
                log.error("Retrying for the Zippos Postal Code. Please stay with us...");
                throw new ZipposTestException("Zippos Postal Code Details Status code mismatched!");
            }
            return ApiConstants.REST_RESOURCE.deserialize(zipposPostalCodeResponse, PostalCodeDetailsResponse.class);
        });
    }

    public CreateUserResponse getCreateUserResponse(String name, String job) {
        return Failsafe.with(new RetryUtils().getRetryPolicyForReqresTestException(2, 3)).get(() -> {
            Response createUserResponse = API_CLIENTS.createUserResponse(name, job);
            if (createUserResponse.getStatusCode() != HttpStatuses.CREATED.getCode()) {
                log.error("Retrying for the Reqres Create User. Please stay with us...");
                throw new ReqresTestException("Reqres Create User status code mismatched!");
            }
            return ApiConstants.REST_RESOURCE.deserialize(createUserResponse, CreateUserResponse.class);
        });
    }


    public RickAndMortyResponse getRickAndMortyResponse(int characterId) {
        return Failsafe.with(new RetryUtils().getRetryPolicyForRickAndMortyTestException(2, 3)).get(() -> {
            Response rickAndMortyCharacterResponse = API_CLIENTS.getRickAndMortyCharacterResponse(characterId);
            if (rickAndMortyCharacterResponse.getStatusCode() != HttpStatuses.OK.getCode()) {
                log.error("Retrying for the Rick And Morty Character. Please stay with us...");
                throw new RickAndMortyTestException("Rick and Morty Get Character Details status code mismatched!");
            }
            return ApiConstants.REST_RESOURCE.deserialize(rickAndMortyCharacterResponse, RickAndMortyResponse.class);
        });
    }

    public IfscCodeDetailsResponse getIfscCodeDetailsResponse(String ifscCode) {
        return Failsafe.with(new RetryUtils().getRetryPolicyForIfscCodeTestException(2, 3)).get(() -> {
            Response ifscCodeResponse = API_CLIENTS.getIfscCodeDetailsResponse(ifscCode);
            if (ifscCodeResponse.getStatusCode() != HttpStatuses.OK.getCode()) {
                log.error("Retrying for the IFSC Code Details. Please stay with us...");
                throw new IFSCCodeTestException("IFSC Code Details Status code mismatched!");
            }
            return ApiConstants.REST_RESOURCE.deserialize(ifscCodeResponse, IfscCodeDetailsResponse.class);
        });
    }

    public GetAllProductListResponse getAllProductListResponse() {
        return Failsafe.with(new RetryUtils().getRetryPolicyForAutomationExerciseException(2, 3)).get(() -> {
            Response productsListResponse = API_CLIENTS.getAllProductsListResponse();
            if (productsListResponse.statusCode() != HttpStatuses.OK.getCode()) {
                log.error("Retrying for the Get All Products List. Please stay with us...");
                throw new AutomationExerciseException("Get All Products List status code mismatched!");
            }
            return ApiConstants.REST_RESOURCE.deserialize(productsListResponse, GetAllProductListResponse.class);
        });
    }
}