# Escape From Tarkov Story Generator

## Program Setup
1. Reload All Maven Projects
2. Setup SDK
3. Import JavaFX lib
4. Make config 
- VM option : --module-path "path\to\lib" --add-modules javafx.controls,javafx.fxml
5. Ensure your API key is an environment variable named `OPENAI_API_KEY`
6. Directly hardcode and replace `null` with API key inside `OpenAIService api = new OpenAIService(null);` ***NOT RECOMMENDED***!
7. Run

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

## Demo: https://drive.google.com/file/d/1gyuEGlKrTRWU43Yevn2lVIo8lZWuFxWA/view?usp=sharing
