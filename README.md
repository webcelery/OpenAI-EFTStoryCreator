# Escape From Tarkov Story Generator

## OpenAI Setup
1. Ensure your API key is an environment variable named `OPENAI_API_KEY`
2. Directly hardcode and replace `null` with API key inside `OpenAIService api = new OpenAIService(null);` ***NOT RECOMMENDED***!
3. Run Main

## Features
- [x] Different writing modes
  - Speech 
  - Raid Report
- [x] Different writing styles
  - Script
  - Action
- [x] Save and load stories 

## Design Patterns
- Strategy:
- `org.example.model.AIStrategy` implemented by `CharacterStrategy` and `RaidReportStrategy` to handle different story behaviors. 
- Observer:
- `StoryObserver` and `StatusObserver` defined by `AIController` use `MainController` to update UI. 
- Singleton: `OpenAIService/OpenAIClient` ensures only one instance of the API is created.  

## Demo: [video link]
