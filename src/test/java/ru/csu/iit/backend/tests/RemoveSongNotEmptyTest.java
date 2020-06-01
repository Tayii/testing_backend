package ru.csu.iit.backend.tests;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.csu.iit.backend.services.SongService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class RemoveSongNotEmptyTest extends BaseTest {
    @Test(groups = "models")
    public void removeSongByStreamerWithCurrentSongEquals2() {
        SongService songService = new SongService(properties);

        // step 5
        RequestSpecification requestSpecification = songService.requestBuilder()
                .setPlaylistType("short")
                .setSongNumber(1)
                .addAuthorization(properties)
                .build();
        String answer = songService.removeSong(requestSpecification);
        assertThat(answer, notNullValue());
        assertThat(answer, not(containsString("1")));

        // step 6
        requestSpecification = songService.requestBuilder()
                .setPlaylistType("short")
                .setSongNumber(2)
                .addAuthorization(properties)
                .build();
        answer = songService.removeSong(requestSpecification);
        assertThat(answer, notNullValue());
        assertThat(answer, not(containsString("2")));

        // step 7
        requestSpecification = songService.requestBuilder()
                .setPlaylistType("short")
                .setSongNumber(3)
                .addAuthorization(properties)
                .build();
        answer = songService.removeSong(requestSpecification);
        assertThat(answer, notNullValue());
        assertThat(answer, containsString("3"));
    }
}
