package ru.csu.iit.backend.builders;

import io.restassured.specification.RequestSpecification;

import java.util.Properties;

public class SongRequestBuilder extends BaseRequestBuilder {
    public SongRequestBuilder(RequestSpecification requestSpecification) {
        super(requestSpecification);
    }

    @Override
    public BaseRequestBuilder addAuthorization(Properties properties) {
        requestSpecification.formParam("access_token", properties.getProperty("access_token"));
        return this;
    }

    public SongRequestBuilder setPlaylistType(String playlist_type) {
        requestSpecification.formParam("playlist_type", playlist_type);
        return this;
    }

    public SongRequestBuilder setSongNumber(int songNumber) {
        requestSpecification.formParam("song_number", String.valueOf(songNumber));
        return this;
    }
}
