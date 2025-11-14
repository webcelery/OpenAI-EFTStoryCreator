package org.example.controller;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Consumer;

public class SaveLoadController
{
    public void save(Component view, String text, Consumer<String> updateStatus)
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save Story");
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        if (chooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
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

    public void load(Component view, Consumer<String> text, Consumer<String> updateStatus)
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Load Story");
        chooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        if (chooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
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