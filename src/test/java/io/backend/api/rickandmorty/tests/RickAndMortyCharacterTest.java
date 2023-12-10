package io.backend.api.rickandmorty.tests;

import io.backend.api.base.BaseTest;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.entities.response.RickAndMortyResponse;
import io.backend.services.ApiHelpers;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class RickAndMortyCharacterTest extends BaseTest {
    @Test(description = "To verify, all the rick and morty character details.", dataProvider = "rick-and-morty-characters", dataProviderClass = ApiDataProvider.class)
    public void testRickAndMortyCharacters(int characterId, String characterName, String characterStatus, String characterOrigin) {
        SoftAssert softAssert = new SoftAssert();
        RickAndMortyResponse responseBody = ApiHelpers.getApiControllers().getRickAndMortyResponse(characterId);
        softAssert.assertEquals(responseBody.getId(), characterId, "Rick And Morty Character Id Failed!");
        softAssert.assertEquals(responseBody.getName(), characterName, "Rick And Morty Character Name Failed!");
        softAssert.assertEquals(responseBody.getStatus(), characterStatus, "Rick And Morty Character Status Failed!");
        softAssert.assertEquals(responseBody.getOrigin().getName(), characterOrigin, "Rick And Morty Character Origin Failed!");
        log.info("Verified the Character ID {}, Character Name {} and Character Status {}", characterId, characterName, characterStatus);
        softAssert.assertAll();
    }
}