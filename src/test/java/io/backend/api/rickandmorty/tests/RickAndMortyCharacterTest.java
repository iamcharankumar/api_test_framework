package io.backend.api.rickandmorty.tests;

import io.backend.api.base.BaseTest;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.commons.HttpStatuses;
import io.backend.entities.response.RickAndMortyResponse;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@Slf4j
public class RickAndMortyCharacterTest extends BaseTest {
    @Test(description = "To verify, all the rick and morty character details.",
            dataProvider = "rick-and-morty-characters", dataProviderClass = ApiDataProvider.class)
    public void testRickAndMortyCharacters(int characterId, String characterName, String characterStatus, String characterOrigin) {
        Map<Response, RickAndMortyResponse> rickAndMortyResponseMap = API_CONTROLLERS.getRickAndMortyResponse(characterId);
        Response response = (Response) rickAndMortyResponseMap.keySet().toArray()[0];
        RickAndMortyResponse responseBody = (RickAndMortyResponse) rickAndMortyResponseMap.values().toArray()[0];
        Assert.assertEquals(response.statusCode(), HttpStatuses.OK.getCode(), "Rick And Morty Character API Failed!");
        Assert.assertEquals(responseBody.getId(), characterId, "Rick And Morty Character Id Failed!");
        Assert.assertEquals(responseBody.getName(), characterName, "Rick And Morty Character Name Failed!");
        Assert.assertEquals(responseBody.getStatus(), characterStatus, "Rick And Morty Character Status Failed!");
        Assert.assertEquals(responseBody.getOrigin().getName(), characterOrigin, "Rick And Morty Character Origin Failed!");
        log.info("Verified the Character ID {}, Character Name {} and Character Status {}", characterId, characterName, characterStatus);
    }
}