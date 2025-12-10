package org.example.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Consumer;

import javafx.stage.FileChooser;
import javafx.stage.Window;

public class SaveLoadController
{
    public void save(Window window, String text, Consumer<String> updateStatus) // add window parameter to connect to parent window
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Story");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File file = chooser.showSaveDialog(window);
        if (file != null)
        {
            if (!file.getName().endsWith(".txt"))
            {
                file = new File(file.getAbsolutePath() + ".txt");
            }

            try
            {
                Files.writeString(file.toPath(), text);
                updateStatus.accept("Saved: " + file.getName());
            }
            catch (IOException e)
            {
                updateStatus.accept("Save failed: " + e.getMessage());
            }
        }
    }

    public void load(Window window, Consumer<String> text, Consumer<String> updateStatus)
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Load Story");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File file = chooser.showOpenDialog(window);
        if (file != null)
        {
            try
            {
                String story = Files.readString(file.toPath());
                text.accept(story);
                updateStatus.accept("Loaded: " + file.getName());
            }
            catch (IOException e)
            {
                updateStatus.accept("Load failed: " + e.getMessage());
            }
        }
    }
}
