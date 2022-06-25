package com.example.cvikpuj;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        Main.primaryStage = stage;
        Main.showWindow(
                "cvik.fxml",
                "Prijavte se na sustav", 650, 300);
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 190);
        stage.setTitle("Dodajte novu kategoriju");
        stage.setScene(scene);
        stage.show();
         */
    }

    public static void showWindow(String viewName, String title, int w, int h) throws IOException {
        FXMLLoader root = new FXMLLoader(Main.class.getResource(viewName));
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root.load(), w, h));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}