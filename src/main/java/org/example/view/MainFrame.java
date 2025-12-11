package org.example.view;

import javafx.scene.layout.BorderPane; 

public class MainFrame
{
    private final InputPanel inputPanel = new InputPanel();
    private final OutputPanel outputPanel = new OutputPanel();
    private final ControlPanel controlPanel = new ControlPanel();

    // create BorderPane layout to contain the panels
    private final BorderPane layout = new BorderPane(); 

    public MainFrame() // of the five regions only use left, center, and bottom
    {
        layout.setLeft(inputPanel);
        layout.setCenter(outputPanel);
        layout.setBottom(controlPanel); 

        inputPanel.getStyleClass().add("input-panel");
        outputPanel.getStyleClass().add("output-panel");
        controlPanel.getStyleClass().add("control-panel");
    }

    public BorderPane getLayout() { return layout; }
        
    public InputPanel getInputPanel() { return inputPanel; }
    public OutputPanel getOutputPanel() { return outputPanel; }
    public ControlPanel getControlPanel() { return controlPanel; }
}
