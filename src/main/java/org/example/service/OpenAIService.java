package org.example.service;

import org.example.util.ErrorHandler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class OpenAIService
{
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private final String apiKey;
    private final HttpClient client;

    public OpenAIService(String apiKey)
    {
        if (apiKey == null) // if apiKey is null use singleton instance
        {
            OpenAIClient singleton = OpenAIClient.getInstance();
            this.apiKey = singleton.getApiKey();
            this.client = singleton.getHttpClient();
        }
        else // use string API key
        {
            this.apiKey = apiKey;
            this.client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(15)).build();
        }
    }

    public String chatComplete(String bodyJson) throws Exception
    {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .timeout(Duration.ofSeconds(60))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(bodyJson, StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200)
            throw ErrorHandler.handleResponseCode(response.statusCode());

        // System.out.println(response.body());

        return response.body();
    }
}