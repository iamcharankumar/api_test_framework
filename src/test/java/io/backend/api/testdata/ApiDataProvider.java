package io.backend.api.testdata;

import io.backend.entities.response.CreateUserResponse;
import io.backend.entities.response.IfscCodeDetailsResponse;
import io.backend.entities.response.PostalCodeDetailsResponse;
import io.backend.entities.response.RickAndMortyResponse;
import io.backend.entities.response.automationexercise.GetAllProductListResponse;
import io.backend.services.rest.ApiHelpers;
import org.testng.annotations.DataProvider;

public class ApiDataProvider {

    @DataProvider(name = "postal-codes", parallel = true)
    private Object[][] postalCodes() {
        return new Object[][]{
                {getPostalCodeDetailsResponse("us", "90210"), "us", "90210", "United States"}
        };
    }

    private PostalCodeDetailsResponse getPostalCodeDetailsResponse(String country, String pinCode) {
        return ApiHelpers.getApiControllers().getPostalCodeDetailsResponse(country, pinCode);
    }

    @DataProvider(name = "create-employee", parallel = true)
    private Object[][] createEmployee() {
        return new Object[][]{
                {"test", "123", "23"}
        };
    }

    @DataProvider(name = "create-user", parallel = true)
    private Object[][] createUser() {
        return new Object[][]{
                {getCreateUserResponse("morpheus", "leader")}
        };
    }

    private CreateUserResponse getCreateUserResponse(String name, String job) {
        return ApiHelpers.getApiControllers().getCreateUserResponse(name, job);
    }

    @DataProvider(name = "rick-and-morty-characters", parallel = true)
    private Object[][] rickAndMortyCharacters() {
        return new Object[][]{
                {getRickAndMortyResponse(50), 50, "Blim Blam", "Alive", "unknown"},
                {getRickAndMortyResponse(290), 290, "Rick Sanchez", "Dead", "Earth (Evil Rick's Target Dimension)"},
                {getRickAndMortyResponse(303), 303, "Samantha", "Alive", "Earth (C-137)"},
                {getRickAndMortyResponse(473), 473, "Bartender Morty", "Alive", "unknown"},
                {getRickAndMortyResponse(572), 572, "Robot Snake", "unknown", "Snake Planet"},
                {getRickAndMortyResponse(653), 653, "Plane Crash Survivor", "unknown", "Near-Duplicate Reality"}
        };
    }

    private RickAndMortyResponse getRickAndMortyResponse(int characterId) {
        return ApiHelpers.getApiControllers().getRickAndMortyResponse(characterId);
    }

    @DataProvider(name = "ifsc-code", parallel = true)
    private Object[][] ifscCodes() {
        return new Object[][]{
                {getIfscCodeDetailsResponse("YESB0DNB002"), "YESB0DNB002"},
                {getIfscCodeDetailsResponse("HDFC0000260"), "HDFC0000260"}
        };
    }

    private IfscCodeDetailsResponse getIfscCodeDetailsResponse(String ifscCode) {
        return ApiHelpers.getApiControllers().getIfscCodeDetailsResponse(ifscCode);
    }

    @DataProvider(name = "get-all-products", parallel = true)
    private Object[][] allProductsList() {
        final GetAllProductListResponse productListResponse = ApiHelpers.getApiControllers().getAllProductListResponse();
        return new Object[][]{
                {productListResponse, 1, "Blue Top", "Rs. 500", "Polo", "Women", "Tops"},
                {productListResponse, 2, "Men Tshirt", "Rs. 400", "H&M", "Men", "Tshirts"},
                {productListResponse, 3, "Sleeveless Dress", "Rs. 1000", "Madame", "Women", "Dress"},
                {productListResponse, 4, "Stylish Dress", "Rs. 1500", "Madame", "Women", "Dress"},
                {productListResponse, 43, "GRAPHIC DESIGN MEN T SHIRT - BLUE", "Rs. 1389", "Mast & Harbour", "Men", "Tshirts"}
        };
    }
}