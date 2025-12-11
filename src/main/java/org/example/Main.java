package org.example;

import org.example.controller.AIController;
import org.example.controller.MainController;
import org.example.controller.SaveLoadController;
import org.example.service.OpenAIService;
import org.example.view.MainFrame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        MainFrame frame = new MainFrame();
        OpenAIService api = new OpenAIService(null);
        AIController aiController = new AIController(api);
        SaveLoadController saveLoadController = new SaveLoadController();

        Scene scene = new Scene(frame.getLayout(), 960, 400);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        
        primaryStage.setTitle("Escape From Tarkov Story Generator");
        primaryStage.setScene(scene);
        primaryStage.show();

        new MainController(frame, aiController, saveLoadController);
    }
}
