package org.example.service;

import org.example.util.ConfigManager;

import java.net.http.HttpClient;
import java.time.Duration;

public class OpenAIClient
{
    private final String apiKey;
    private final String model;
    private final HttpClient http;

    private OpenAIClient() // fallbacks to config if environment variable is not set
    {
        String envApiKey = System.getenv("OPENAI_API_KEY"); // get API key from environment variable

        if (envApiKey != null)
        {
            this.apiKey = envApiKey;
            this.model = "gpt-3.5-turbo";
        }
        else // if environment variable is not set then read from config file
        {
            ConfigManager configuration = new ConfigManager();
            this.apiKey = configuration.requireApiKey();
            this.model = configuration.getModel();
        }
        this.http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(15)).build();
    }
    public static OpenAIClient getInstance()
    {
        return InstanceHolder.INSTANCE;
    }
    public String getApiKey() { return apiKey; }
    public String getModel() { return model; }
    public HttpClient getHttpClient() { return http; }

    private static final class InstanceHolder
    {
        private static final OpenAIClient INSTANCE = new OpenAIClient();
    }
}