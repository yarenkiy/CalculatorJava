package com.example.project2_;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
    public CalculatorApp() {
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("calculator.fxml"));
        primaryStage.setTitle("JavaFX Calculator");
        primaryStage.setScene(new Scene(root, 300.0, 400.0));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
