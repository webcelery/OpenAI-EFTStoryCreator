package org.example.controller;

import org.example.model.AIStrategy;
import org.example.model.CharacterStrategy;
import org.example.model.RaidReportStrategy;
import org.example.view.MainFrame;

import javafx.application.Platform;
import javafx.stage.Window;

//     (parameter) -> {body} = lambda expression

public class MainController
{
    private final MainFrame view;
    private final AIController aiController;
    private final SaveLoadController saveLoadController;

    public MainController(MainFrame view, AIController aiController, SaveLoadController saveLoadController)
    {
        this.view = view;
        this.aiController = aiController;
        this.saveLoadController = saveLoadController;

        setObservers(); // set AIController observers
        setControls(); // set button actions
    }

    private void setObservers()
    {
        // update output panel with content from response
        aiController.setStoryObserver(text -> Platform.runLater(() -> view.getOutputPanel().setText(text)));

        // update status label
        aiController.setStatusObserver(status -> Platform.runLater(() -> view.getControlPanel().setStatus(status)));
    }

    private void setControls()
    {
        view.getControlPanel().create(e -> handleCreateStory());
        view.getControlPanel().save(e -> handleSave());
        view.getControlPanel().load(e -> handleLoad());
    }

    private AIStrategy createStrategy(String mode)
    {
        if ("Speech".equals(mode)) return new CharacterStrategy();
        return new RaidReportStrategy();
    }

    private void handleCreateStory() // creates story based on user input
    {
        String mode = view.getInputPanel().getMode();
        AIStrategy strategy = createStrategy(mode);

        if ("Speech".equals(mode) && view.getInputPanel().getCharacters().isEmpty())
        {
            view.getControlPanel().setStatus("Choose a character!");
            return;
        }

        view.getControlPanel().setStatus("Creating...");
        aiController.createStory(
                strategy,
                mode,
                view.getInputPanel().getCharacters(),
                view.getInputPanel().getSelectedStyle()
        );
    }

    // get window for save/load dialog and prevent null pointer exception
    private Window scene()
    { // get window from input panel, it doesn't matter which panel we get it from
        return view.getInputPanel().getScene() != null ? view.getInputPanel().getScene().getWindow() : null;

        /* works too
        return view.getControlPanel().getScene() != null ? view.getControlPanel().getScene().getWindow() : null;
        return view.getOutputPanel().getScene() != null ? view.getOutputPanel().getScene().getWindow() : null;
        */
    }

    private void handleSave()
    {
        saveLoadController.save(scene(), view.getOutputPanel().getText(),
                status -> view.getControlPanel().setStatus(status));
    }

    private void handleLoad()
    {
        saveLoadController.load(scene(),
                text -> view.getOutputPanel().setText(text),
                status -> view.getControlPanel().setStatus(status));
    }
}
