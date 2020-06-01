package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SongModel {
    @JsonProperty(value = "song_username")
    private String song_username;
    @JsonProperty(value = "song_title")
    private String song_title;
    @JsonProperty(value = "song_link")
    private String song_link;
    @JsonProperty(value = "start_time")
    private int start_time;

    public String getSongUsername() {
        return song_username;
    }

    public void setSongUsername(String song_username) {
        this.song_username = song_username;
    }

    public String getSongTitle() {
        return song_title;
    }

    public void setSongTitle(String song_title) {
        this.song_title = song_title;
    }

    public String getSongLink() {
        return song_link;
    }

    public void setSongLink(String song_link) {
        this.song_link = song_link;
    }

    public int getStartTime() {
        return start_time;
    }

    public void setStartTime(int start_time) {
        this.start_time = start_time;
    }

    @Override
    public String toString() {
        return "SongModel{" +
                "song_username='" + song_username + "'" +
                ", song_title='" + song_title + '\'' +
                ", song_link='" + song_link + '\'' +
                ", start_time=" + start_time +
                '}';
    }
}
