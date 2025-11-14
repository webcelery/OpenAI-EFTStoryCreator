package org.example.controller;

import org.example.model.AIStrategy;
import org.example.service.OpenAIService;
import org.example.util.RequestBuilder;
import org.example.util.ResponseParser;

import java.util.List;

public class AIController
{
    private final OpenAIService api;
    private StoryObserver storyObserver;
    private StatusObserver statusObserver;

    public AIController(OpenAIService api) { this.api = api; }
    public void setStoryObserver(StoryObserver observer) { this.storyObserver = observer; }
    public void setStatusObserver(StatusObserver observer) { this.statusObserver = observer; }
    public void createStory(AIStrategy strategy, String mode, List<String> characters, String style)
    {
        String instructions =
                """
                        You are a lore accurate storyteller inside the world of Escape from Tarkov.
                        Use only canon details in the provided context.
                        Keep lore-accurate and do not contradict or invent anything new.
                        """;

        new Thread(() -> // story creation runs on separate thread
        {
            try
            {
                int maxTokens = 500;
                String prompt = strategy.buildPrompt(mode, characters, style);

                String model = org.example.service.OpenAIClient.getInstance().getModel();
                String body = RequestBuilder.chatRequest(instructions, prompt, model, maxTokens);

                String response = api.chatComplete(body);
                String result = ResponseParser.parseResponse(response);

                // notify observers with results
                storyObserver.storyResult(result);
                statusObserver.statusUpdate("Complete!");
            }
            catch (Exception e)
            {
                statusObserver.statusUpdate(e.getMessage());
            }
        }).start();
    }
    // functional interfaces
    public interface StoryObserver
    {
        void storyResult(String text);
    }

    public interface StatusObserver
    {
        void statusUpdate(String status);
    }
}