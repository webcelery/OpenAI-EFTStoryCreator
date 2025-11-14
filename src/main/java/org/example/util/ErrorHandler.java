package org.example.util;

public class ErrorHandler
{
    public static RuntimeException handleResponseCode(int responseCode)
    {
        if (responseCode == 401) return new RuntimeException("Invalid API key.");
        if (responseCode == 429) return new RuntimeException("Too many requests.");
        if (responseCode >= 500) return new RuntimeException("Server error: " + responseCode);
        return new RuntimeException("Error: " + responseCode);
    }
}