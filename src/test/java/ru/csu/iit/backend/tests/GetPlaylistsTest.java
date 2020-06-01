package ru.csu.iit.backend.tests;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.csu.iit.backend.models.PlaylistModel;
import ru.csu.iit.backend.models.SongModel;
import ru.csu.iit.backend.services.PlaylistService;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GetPlaylistsTest extends BaseTest {
    @Test(groups = "models")
    public void getAllPlaylists() {
        PlaylistService playlistsService = new PlaylistService(properties);
        RequestSpecification requestSpecification = playlistsService.requestBuilder()
                .build();
        PlaylistModel playlists = playlistsService.getPlaylists(requestSpecification);
        assertThat(playlists.getCurrentPlaylistType(), notNullValue());
        assertThat(playlists.getCurrentSongNumber(), notNullValue());
        assertThat(playlists.getCurrentSongNumber(), greaterThanOrEqualTo(0));
        String playlist_type = playlists.getCurrentPlaylistType();
        assertThat(playlists
                .getPlaylists()
                .getOrDefault(playlist_type, null),
                notNullValue());
        Map<Integer, SongModel> playlist = playlists.getPlaylists().get(playlist_type);
        playlist.forEach((integer, songModel) -> {
            assertThat(integer, notNullValue());
            assertThat(integer, greaterThanOrEqualTo(1));
            assertThat(songModel, notNullValue());
            assertThat(songModel.getSongUsername(), notNullValue());
            assertThat(songModel.getSongTitle(), notNullValue());
            assertThat(songModel.getSongLink(), notNullValue());
            assertThat(songModel.getStartTime(), notNullValue());
            assertThat(songModel.getStartTime(), greaterThanOrEqualTo(0));
        });
    }
}
