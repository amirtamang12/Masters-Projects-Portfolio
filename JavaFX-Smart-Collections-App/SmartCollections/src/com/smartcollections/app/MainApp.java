package com.smartcollections.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * MainApp - entry point for Smart Collections.
 * Loads the FXML layout and starts the JavaFX stage.
 */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/smartcollections/ui/MainView.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Smart Collections");
        primaryStage.setScene(new Scene(root, 1100, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX runtime
    }
}
