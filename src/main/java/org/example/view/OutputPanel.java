package org.example.view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class OutputPanel extends BorderPane // BorderPane layout to center story
{
    private final TextArea textArea = new TextArea();

    public OutputPanel()
    {
        textArea.setWrapText(true);

        // this is not the same as setCenter in MainFrame
        setCenter(textArea); // places text inside the outputPanel
    }

    public String getText() { return textArea.getText(); }
    public void setText(String text) { textArea.setText(text); }
}
