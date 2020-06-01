package ru.csu.iit.backend.tests;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.csu.iit.backend.services.SongService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class RemoveSongEmptyTest extends BaseTest {
    @Test(groups = "models")
    public void removeSongByStreamerWithEmptyPlaylist() {
        SongService songService = new SongService(properties);

        // step 1
        RequestSpecification requestSpecification = songService.requestBuilder()
                .build();
        String answer = songService.removeSong(requestSpecification);
        assertThat(answer, emptyOrNullString());

        // step 2
        requestSpecification = songService.requestBuilder()
                .setPlaylistType("short")
                .setSongNumber(1)
                .build();
        answer = songService.removeSong(requestSpecification);
        assertThat(answer, emptyOrNullString());

        // step 3
        requestSpecification = songService.requestBuilder()
                .addAuthorization(properties)
                .build();
        answer = songService.removeSong(requestSpecification);
        assertThat(answer, emptyOrNullString());

        // step 3
        requestSpecification = songService.requestBuilder()
                .setPlaylistType("short")
                .setSongNumber(1)
                .addAuthorization(properties)
                .build();
        answer = songService.removeSong(requestSpecification);
        assertThat(answer, emptyOrNullString());
    }
}
