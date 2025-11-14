package org.example.util;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager
{
    private final String apiKey;
    private final String model;

    public ConfigManager()
    {
        try (InputStream input = getClass().getResourceAsStream("/config.properties.example"))
        {
            Properties property = new Properties();
            property.load(input);

            apiKey = property.getProperty("api.key");
            model = property.getProperty("api.model");
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to load config.properties.example", e);
        }
    }

    public String requireApiKey()
    {
        if (apiKey == null)
        {
            throw new IllegalStateException("api.key is not set in config.properties.example");
        }
        return apiKey;
    }

    public String getModel() { return model; }
}