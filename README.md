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

## Output
*Both images show example stories returned by the API based on inputs from the control panel.*

<img width="1342" height="602" alt="killa-story" src="https://github.com/user-attachments/assets/8785580a-5f67-4902-a0fc-3d87904857e3" />
<img width="1342" height="602" alt="shturman-story" src="https://github.com/user-attachments/assets/89cab6b7-0a9b-4de4-a831-4b33a1d51f5e" />

## Demo: https://drive.google.com/file/d/1gyuEGlKrTRWU43Yevn2lVIo8lZWuFxWA/view?usp=sharing
