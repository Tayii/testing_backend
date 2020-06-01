package ru.csu.iit.backend.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.PlaylistRequestBuilder;
import ru.csu.iit.backend.models.PlaylistModel;

import com.google.gson.Gson;

import java.util.Properties;

public class PlaylistService extends BaseService {
    private static final String ENDPOINT = "command_get.php";

    public PlaylistService(Properties properties) {
        super(properties);
    }

    public PlaylistRequestBuilder requestBuilder() {
        return new PlaylistRequestBuilder(baseRequest());
    }

    public PlaylistModel getPlaylists(RequestSpecification requestSpecification) {
        Gson gson = new Gson();
        String s = executeGetPlaylists(requestSpecification).then()
                .extract()
                .body()
                .asString();
        return gson.fromJson(s, PlaylistModel.class);
    }

    public Response executeGetPlaylists(RequestSpecification requestSpecification) {
        return requestSpecification.get(ENDPOINT);
    }
}
