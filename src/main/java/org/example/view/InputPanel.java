package org.example.view;

import org.example.util.JSONUtil;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;

public class InputPanel extends VBox // VBox arranges controls in a single vertical column
{
    final ComboBox<String> mode = new ComboBox<>();
    final ComboBox<String> style = new ComboBox<>();
    final ListView<String> characterList = new ListView<>();

    public InputPanel()
    {
        setPadding(new Insets(10));

        Label modeLabel = new Label("Mode");
        mode.getItems().addAll("Speech", "Raid Report");
        mode.setValue("Speech");

        Label styleLabel = new Label("Style");
        style.getItems().addAll("Script", "Action");
        style.setValue("Script");

        Label charactersLabel = new Label("Characters");
        List<String> characterNames = JSONUtil.loadCharacterNames();
        characterList.getItems().addAll(characterNames);
        characterList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        getChildren().addAll(modeLabel, mode, styleLabel, style, charactersLabel, characterList);
    }

    public String getMode() { return mode.getValue(); }
    public String getSelectedStyle() { return style.getValue(); }

    public List<String> getCharacters()
    {
        return new ArrayList<>(characterList.getSelectionModel().getSelectedItems());
    }
}
