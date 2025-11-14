package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel
{
    public final JButton createButton = new JButton("Create Story");
    public final JButton saveButton = new JButton("Save");
    public final JButton loadButton = new JButton("Load");
    public final JLabel statusLabel = new JLabel("");

    public ControlPanel()
    {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        add(createButton);
        add(saveButton);
        add(loadButton);
        add(statusLabel);
    }

    public void create(ActionListener listener)
    {
        createButton.addActionListener(listener);
    }

    public void save(ActionListener listener)
    {
        saveButton.addActionListener(listener);
    }

    public void load(ActionListener listener)
    {
        loadButton.addActionListener(listener);
    }

    public void setStatus(String string) { statusLabel.setText(string); }
}