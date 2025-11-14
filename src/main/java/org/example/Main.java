package org.example;

import org.example.controller.AIController;
import org.example.controller.MainController;
import org.example.controller.SaveLoadController;
import org.example.service.OpenAIService;
import org.example.view.MainFrame;

public class Main
{
    public static void main(String[] args)
    {
        MainFrame frame = new MainFrame();
        OpenAIService api = new OpenAIService(null);
        AIController aiController = new AIController(api);
        SaveLoadController saveLoadController = new SaveLoadController();

        new MainController(frame, aiController, saveLoadController);
        frame.setVisible(true);
    }
}