package org.example.model;

import java.util.List;

public class RaidReportStrategy implements AIStrategy
{
    public String buildPrompt(String mode, List<String> characters, String style)
    {
        String character = characters.get(0);

        return
                """
                        Create a lore accurate raid report set in game Escape from Tarkov: %s
                        
                        Use Tarkov terms (PMCs, Scavs, maps, gear).
                        Style: %s
                        Mention only the listed canon terms
                        Keep lore-accurate and do not contradict or invent anything new.
                        """.formatted(character, style);
    }
}