package org.example.view;

import org.example.util.JSONUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InputPanel extends JPanel
{
    final JComboBox<String> mode = new JComboBox<>();
    final JList<String> characterList = new JList<>();
    final JComboBox<String> style = new JComboBox<>();

    InputPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(new JLabel("Mode"));
        mode.addItem("Speech");
        mode.addItem("Raid Report");
        mode.setMaximumSize(new Dimension(200, 25));
        add(mode);

        add(new JLabel("Style"));
        style.addItem("Script");
        style.addItem("Action");
        style.setSelectedItem("Script");
        style.setMaximumSize(new Dimension(200, 25));
        add(style);

        add(new JLabel("Characters"));
        List<String> characters = JSONUtil.loadCharacterNames();
        characterList.setListData(characters.toArray(new String[0]));
        characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(characterList);
        add(scroll);
    }

    public String getMode() { return (String) mode.getSelectedItem(); }
    public String getStyle()
    {
        return (String) style.getSelectedItem();
    }
    public List<String> getCharacters()
    {
        return characterList.getSelectedValuesList();
    }
}