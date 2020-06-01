package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class PlaylistModel {
    @JsonProperty(value = "current_playlisttype")
    private String current_playlisttype;
    @JsonProperty(value = "current_songnumber")
    private int current_songnumber;
    @JsonProperty(value = "playlists")
    private Map<String, Map<Integer, SongModel>> playlists;

    public String getCurrentPlaylistType() {
        return current_playlisttype;
    }

    public void setCurrentPlaylistType(String current_playlist_type) {
        this.current_playlisttype = current_playlist_type;
    }

    public int getCurrentSongNumber() {
        return current_songnumber;
    }

    public void setCurrentSongNumber(int current_song_number) {
        this.current_songnumber = current_song_number;
    }

    public Map<String, Map<Integer, SongModel>> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Map<String, Map<Integer, SongModel>> playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        return "PlaylistModel{" +
                "current_playlist_type='" + current_playlisttype + "'" +
                ", current_song_number=" + current_songnumber +
                ", playlists=" + playlists +
                '}';
    }
}
