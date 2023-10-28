package io.backend.services;

import io.backend.entities.request.CreateEmployeeRequest;
import io.backend.entities.request.CreateUsersRequest;
import io.backend.entities.response.CreateEmployeeResponse;
import io.backend.entities.response.CreateUserResponse;
import io.backend.entities.response.PostalCodeDetailsResponse;
import io.backend.entities.response.RickAndMortyResponse;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.util.Collections;
import java.util.Map;

public class ApiControllers extends ApiClients {

    @SneakyThrows
    public Map<Response, PostalCodeDetailsResponse> getPostalCodeDetailsResponse(String country, String pinCode) {
        Response postalCodeResponse = getPostalCodeResponse(country, pinCode);
        if (postalCodeResponse != null)
            return Collections.singletonMap(postalCodeResponse, deserialize(postalCodeResponse, PostalCodeDetailsResponse.class));
        else
            throw new Exception("POSTAL CODE DETAILS API FAILED!");
    }

    @SneakyThrows
    public Map<Response, CreateEmployeeResponse> getCreateEmployeeResponse(CreateEmployeeRequest createEmployeeRequest) {
        Response createEmployeeResponse = createEmployeeResponse(createEmployeeRequest);
        if (createEmployeeResponse != null)
            return Collections.singletonMap(createEmployeeResponse, deserialize(createEmployeeResponse, CreateEmployeeResponse.class));
        else
            throw new Exception("CREATE EMPLOYEE API FAILED!");
    }

    @SneakyThrows
    public Map<Response, CreateUserResponse> getCreateUserResponse(CreateUsersRequest createUsersRequest) {
        Response createUserResponse = createUserResponse(createUsersRequest);
        if (createUserResponse != null)
            return Collections.singletonMap(createUserResponse, deserialize(createUserResponse, CreateUserResponse.class));
        else
            throw new Exception("CREATE USER API FAILED!");
    }

    @SneakyThrows
    public Map<Response, RickAndMortyResponse> getRickAndMortyResponse(int characterId) {
        Response rickAndMortyCharacterResponse = getRickAndMortyCharacterResponse(characterId);
        if (rickAndMortyCharacterResponse != null)
            return Collections.singletonMap(rickAndMortyCharacterResponse, deserialize(rickAndMortyCharacterResponse, RickAndMortyResponse.class));
        else
            throw new Exception("RICK AND MORTY CHARACTER API FAILED!");
    }
}