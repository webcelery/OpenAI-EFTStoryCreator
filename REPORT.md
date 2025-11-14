# Project Report

## Challenges
**Challenge 1: Using lambda expressions**
- Learning how to implement lambda expressions was difficult. Not only was the syntax confusing, but I also forgot how to use them. By watching [Lambda Expressions in Java ](https://www.youtube.com/watch?v=tj5sLSFjVj4) and practicing a lot, I got the hang of it. Not only did I learn when to best use them, but also understood the core logic behind asynchronous and callbacks when I applied them into observers and story creation in `MainController`/`AIController`.

**Challenge 2: Understanding the observer pattern**
- I was struggling to understand how the observer pattern works. I used website [Observer](https://refactoring.guru/design-patterns/observer) and ChatGPT to better my understanding. The observer pattern uses subject `AIController` and observers `StoryObserver`/`StatusObserver` to update the UI in `MainController` when there are changes in story creation.

## Design Pattern Justifications
- **Strategy Pattern:** 
Allows easy switching between story strategies without changing core logic. (if/else) `CharacterStrategy` for speech dialogs and `RaidReportStrategy` for reports on raid encounters. 
- **Observer Pattern:** Allows `MainController` to update the UI when story completes or fails from `AIController`. In other words it separates UI updates from story creation.
- **Singleton:**
Ensures only one instance of `OpenAIClient`. Not only helps with code reusability but manages resources as creating multiple instances is costly.

## AI Usage
- Used ChatGPT to clarify the observer design pattern. Asked for a simple explanation as I was struggling to understand it.
- Used ChatGPT to create eft_characters.json. Asked for a list of Tarkov characters in JSON format. 
I then cleaned up and removed characters there were not present in game version. `0.14.0.0.28333 (27 Dec 2023)` 
*(This was the version I played the most.)* 
