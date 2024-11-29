package io.backend.services.rest;

import io.backend.commons.RestResource;
import io.backend.constants.ApiConstants;
import io.backend.constants.ApiRoutes;
import io.backend.entities.request.CreateUsersRequest;
import io.restassured.response.Response;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Objects;

@NoArgsConstructor
public class ApiClients {
    public Response getPostalCodeResponse(String country, String pinCode) {
        String postalCodeEndPoint = ApiRoutes.GET_POSTAL_CODE_INFO + country + "/" + pinCode;
        Response postalCodeResponse = RestResource.getInstance().getApiResponse(postalCodeEndPoint);
        Objects.requireNonNull(postalCodeResponse, "Client Exception: Zippost Postal Code API");
        return postalCodeResponse;
    }

    @SneakyThrows
    public Response createUserResponse(String name, String job) {
        CreateUsersRequest createUsersRequest = new CreateUsersRequest(name, job);
        String request = RestResource.getInstance().serialize(createUsersRequest);
        Response createResponse = RestResource.getInstance().postApiResponse(request, ApiRoutes.POST_CREATE_USER);
        Objects.requireNonNull(createResponse, "Client Exception: Reqres Create User API");
        return createResponse;
    }

    public Response getRickAndMortyCharacterResponse(int characterId) {
        String rickAndMortyCharacterEndPoint = ApiRoutes.GET_RICK_AND_MORTY_CHARACTER + characterId;
        Response rickAndMortyCharacterResponse = RestResource.getInstance().getApiResponse(rickAndMortyCharacterEndPoint);
        Objects.requireNonNull(rickAndMortyCharacterResponse, "Client Exception: Rick And Morty Character Details API");
        return rickAndMortyCharacterResponse;
    }

    public Response getIfscCodeDetailsResponse(String ifscCode) {
        String ifscCodeDetailsEndPoint = ApiRoutes.IFSC_CODE_DETAILS + ifscCode;
        Response ifscCodeDetailsResponse = RestResource.getInstance().getApiResponse(ifscCodeDetailsEndPoint);
        Objects.requireNonNull(ifscCodeDetailsResponse, "Client Exception: IFSC Code Details API");
        return ifscCodeDetailsResponse;
    }

    public Response getAllProductsListResponse() {
        String productsListEndPoint = ApiRoutes.GET_ALL_PRODUCTS_LIST;
        Response productsListResponse = ApiConstants.REST_RESOURCE.getApiResponse(productsListEndPoint);
        Objects.requireNonNull(productsListResponse, "Client Exception: Automation Exercise Get All Products List API");
        return productsListResponse;
    }
}