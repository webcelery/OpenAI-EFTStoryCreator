package org.example.controller;

import org.example.model.AIStrategy;
import org.example.model.CharacterStrategy;
import org.example.model.RaidReportStrategy;
import org.example.view.MainFrame;

import javax.swing.*;

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
        aiController.setStoryObserver( // update output panel with content from response
                text -> SwingUtilities.invokeLater(() -> view.getOutputPanel().setText(text))
        );
        aiController.setStatusObserver( // update status label
                status -> SwingUtilities.invokeLater(() -> view.getControlPanel().setStatus(status))
        );
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
                view.getInputPanel().getStyle()
        );
    }

    private void handleSave() // saves current story to file
    {
        saveLoadController.save(
                view,
                view.getOutputPanel().getText(),
                (status) -> view.getControlPanel().setStatus(status)
        );
    }

    private void handleLoad() // loads story from file
    {
        saveLoadController.load(
                view,
                (text) -> view.getOutputPanel().setText(text),
                (status) -> view.getControlPanel().setStatus(status)
        );
    }
}