package io.backend.services;

import io.backend.commons.ResponseHandlers;
import io.backend.constants.ApiEndPoints;
import io.backend.entities.request.CreateEmployeeRequest;
import io.backend.entities.request.CreateUsersRequest;
import io.restassured.response.Response;

public class ApiClients extends ResponseHandlers {
    public Response getPostalCodeResponse(String country, String pinCode) {
        String postalCodeEndPoint = ApiEndPoints.GET_POSTAL_CODE_INFO + "/" + country + "/" + pinCode;
        return getApiResponse(postalCodeEndPoint);
    }

    public Response createEmployeeResponse(CreateEmployeeRequest createEmployeeRequest) {
        String request = createEmployeeRequest.toString();
        String createEmployeeEndPoint = ApiEndPoints.POST_CREATE_EMPLOYEE;
        return postApiResponse(request, createEmployeeEndPoint);
    }

    public Response createUserResponse(CreateUsersRequest createUsersRequest) {
        String request = createUsersRequest.toString();
        String createUserEndPoint = ApiEndPoints.POST_CREATE_USER;
        return postApiResponse(request, createUserEndPoint);
    }
}