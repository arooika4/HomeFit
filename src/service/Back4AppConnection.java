package service;

import java.net.HttpURLConnection;
import java.net.URL;

public class Back4AppConnection {

    public static final String APPLICATION_ID = "V6pp2LfU6ZLO3X5O9ZMzpzsArgN29iX7r9FbENXD";
    public static final String REST_API_KEY = "O4zVPA8wNkgSQVcYgd1E6BUbj5fZAJXs7p73gv9W";
    public static final String API_URL = "https://parseapi.back4app.com/classes/";

    public static HttpURLConnection conectar(String endpoint, String metodo) throws Exception {

        URL url = new URL(API_URL + endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod(metodo);

        conn.setRequestProperty("X-Parse-Application-Id", APPLICATION_ID);
        conn.setRequestProperty("X-Parse-REST-API-Key", REST_API_KEY);
        conn.setRequestProperty("Content-Type", "application/json");

        conn.setDoOutput(true);

        return conn;
    }
}
