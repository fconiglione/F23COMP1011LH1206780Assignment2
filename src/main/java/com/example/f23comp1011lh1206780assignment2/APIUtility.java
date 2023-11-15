package com.example.f23comp1011lh1206780assignment2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class APIUtility {
    private static final String CLIENT_ID = "c202326fc3044e88b9241398217d8d7b";
    private static final String CLIENT_SECRET = "2442051c40d34b8a9cb6410644b5250e";

    /**
     * This method retrieves the access token from the Spotify API, using the Client Id and Client Secret
     * declared above - this is necessary because the Spotify API expires tokens after some time, and thus,
     * they constantly change
     * Referenced from: https://stackoverflow.com/questions/69576906/retrieve-access-token-from-server-with-java-httpclient-using-client-credentials
     * @return
     */
    static String getAccessToken() {
        try {
            URL url = new URL("https://accounts.spotify.com/api/token");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            String credentials = CLIENT_ID + ":" + CLIENT_SECRET;
            String base64Credentials = Base64.getEncoder().encodeToString(credentials.getBytes());
            connection.setRequestProperty("Authorization", "Basic " + base64Credentials);

            String requestBody = "grant_type=client_credentials";
            connection.setDoOutput(true);
            connection.getOutputStream().write(requestBody.getBytes());

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder responseContent = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }

                    JsonObject jsonResponse = new Gson().fromJson(responseContent.toString(), JsonObject.class);

                    return jsonResponse.get("access_token").getAsString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This method executes the search, given the term (for example, "Godzilla") and
     * the access token, and returns the corresponding Json data from the Spotify API
     * @param accessToken
     * @param searchTerm
     * @return
     */
    static APIResponse searchForTrack(String accessToken, String searchTerm) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            // Had to add an API request limit of 50 results as this is the maximum allowed by Spotify
            String apiUrl = "https://api.spotify.com/v1/search?q=" + searchTerm + "&type=track&limit=50";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Authorization", "Bearer " + accessToken)
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            return new Gson().fromJson(responseBody, APIResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
