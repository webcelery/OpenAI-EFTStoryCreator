package org.example.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private final InputPanel inputPanel = new InputPanel();
    private final OutputPanel outputPanel = new OutputPanel();
    private final ControlPanel controlPanel = new ControlPanel();

    public MainFrame()
    {
        setTitle("Escape From Tarkov Story Generator");
        setSize(960, 400);

        add(inputPanel, BorderLayout.WEST);
        add(outputPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public InputPanel getInputPanel() { return inputPanel; }
    public OutputPanel getOutputPanel() { return outputPanel; }
    public ControlPanel getControlPanel() { return controlPanel; }
}