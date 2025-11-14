package org.example.view;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel
{
    final JTextArea textArea = new JTextArea();

    public OutputPanel()
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(textArea);
        add(scroll, BorderLayout.CENTER);

        textArea.setFont(new Font("sans-serif", Font.PLAIN, 13));
        textArea.setLineWrap(true);
    }

    public String getText()
    {
        return textArea.getText();
    }
    public void setText(String text) { textArea.setText(text); }
}