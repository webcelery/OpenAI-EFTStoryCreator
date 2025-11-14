package org.example.model;

import java.util.List;

public class CharacterStrategy implements AIStrategy
{
    public String buildPrompt(String mode, List<String> characters, String style)
    {
        String character = characters.get(0);

        return
                """
                        Create a speech for the game Escape From Tarkov:
                        
                        First-person voice from %s
                        Style: %s
                        Keep lore-accurate and do not contradict or invent anything new.
                        """.formatted(character, style);
    }
}