package io.backend.services.rest;

import io.backend.commons.RestResource;
import io.backend.constants.ApiRoutes;
import io.backend.entities.request.CreateUsersRequest;
import io.backend.exceptions.IFSCCodeTestException;
import io.backend.exceptions.ReqresTestException;
import io.backend.exceptions.RickAndMortyTestException;
import io.backend.exceptions.ZipposTestException;
import io.restassured.response.Response;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor
public class ApiClients {
    public Response getPostalCodeResponse(String country, String pinCode) {
        String postalCodeEndPoint = ApiRoutes.GET_POSTAL_CODE_INFO + country + "/" + pinCode;
        Response postalCodeResponse = RestResource.getInstance().getApiResponse(postalCodeEndPoint);
        if (postalCodeResponse != null)
            return postalCodeResponse;
        else
            throw new ZipposTestException("Client Exception: Zippost Postal Code API");
    }

    @SneakyThrows
    public Response createUserResponse(CreateUsersRequest createUsersRequest) {
        String createUserEndPoint = ApiRoutes.POST_CREATE_USER;
        String request = RestResource.getInstance().serialize(createUsersRequest);
        Response createResponse = RestResource.getInstance().postApiResponse(request, createUserEndPoint);
        if (createResponse != null)
            return createResponse;
        else
            throw new ReqresTestException("Client Exception: Reqres Create User API");
    }

    public Response getRickAndMortyCharacterResponse(int characterId) {
        String rickAndMortyCharacterEndPoint = ApiRoutes.GET_RICK_AND_MORTY_CHARACTER + characterId;
        Response rickAndMortyCharacterResponse = RestResource.getInstance().getApiResponse(rickAndMortyCharacterEndPoint);
        if (rickAndMortyCharacterResponse != null)
            return rickAndMortyCharacterResponse;
        else
            throw new RickAndMortyTestException("Client Exception: Rick And Morty Character Details API");
    }

    public Response getIfscCodeDetailsResponse(String ifscCode) {
        String ifscCodeDetailsEndPoint = ApiRoutes.IFSC_CODE_DETAILS + ifscCode;
        Response ifscCodeDetailsResponse = RestResource.getInstance().getApiResponse(ifscCodeDetailsEndPoint);
        if (ifscCodeDetailsResponse != null)
            return ifscCodeDetailsResponse;
        else
            throw new IFSCCodeTestException("Client Exception: IFSC Code Details API");
    }
}