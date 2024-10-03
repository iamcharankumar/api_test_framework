package io.backend.api.rickandmorty.tests;

import io.backend.api.base.BaseTest;
import io.backend.api.constants.TestGroups;
import io.backend.api.testdata.ApiDataProvider;
import io.backend.entities.response.RickAndMortyResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class RickAndMortyCharacterTest extends BaseTest {
    @Test(description = "To verify, all the rick and morty character details.", dataProvider = "rick-and-morty-characters",
            dataProviderClass = ApiDataProvider.class, groups = {TestGroups.RICK_MORTY_SMOKE, TestGroups.RICK_MORTY_REGRESSION,
            TestGroups.ALL_SMOKE, TestGroups.ALL_REGRESSION})
    public void testRickAndMortyCharacters(RickAndMortyResponse rickAndMortyResponse, int characterId,
                                           String characterName, String characterStatus, String characterOrigin) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rickAndMortyResponse.getId(), characterId, "Rick And Morty Character Id Failed!");
        softAssert.assertEquals(rickAndMortyResponse.getName(), characterName, "Rick And Morty Character Name Failed!");
        softAssert.assertEquals(rickAndMortyResponse.getStatus(), characterStatus, "Rick And Morty Character Status Failed!");
        softAssert.assertEquals(rickAndMortyResponse.getOrigin().getName(), characterOrigin, "Rick And Morty Character Origin Failed!");
        softAssert.assertAll();
        log.info("Verified the Character ID {}, Character Name {} and Character Status {}", characterId, characterName, characterStatus);
    }
}