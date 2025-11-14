package org.example.model;

import java.util.List;

public interface AIStrategy
{
    String buildPrompt(String mode, List<String> characters, String style);
}