package org.example.view;

import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControlPanel extends HBox // HBox arranges controls for horizontal layout
{
    public final Button createButton = new Button("Create Story");
    public final Button saveButton = new Button("Save");
    public final Button loadButton = new Button("Load");
    public final Label statusLabel = new Label("");

    public ControlPanel()
    {
        setSpacing(10);
        setPadding(new Insets(10));
        getChildren().addAll(createButton, saveButton, loadButton, statusLabel);
    }

    // "EventHandler<ActionEvent> handler" allows passing a method to handle button clicks
    public void create(EventHandler<ActionEvent> handler) { createButton.setOnAction(handler); }
    public void save(EventHandler<ActionEvent> handler) { saveButton.setOnAction(handler); }
    public void load(EventHandler<ActionEvent> handler) { loadButton.setOnAction(handler); }
    
    public void setStatus(String string) { statusLabel.setText(string); }
}
