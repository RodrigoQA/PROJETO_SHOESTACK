package api.core;

import io.restassured.http.ContentType;

public interface Constantes {
    String APP_BASE_URL = "https://api.trello.com/1/actions/592f11060f95a3d3d46a987a";
   // Integer APP_PORT = 443;
    String APP_BASE_PATH = "";

    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 10000L;


}
