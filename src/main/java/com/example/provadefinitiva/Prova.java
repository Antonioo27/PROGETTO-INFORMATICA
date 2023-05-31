package com.example.provadefinitiva;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Prova extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Image icon = new Image("C:\\Users\\HP\\ProvaDefinitiva\\src\\logo.png");
        stage.getIcons().add(icon);
        stage.setTitle("LOGIN PAGE");
        //stage.setFullScreen(true);

        //commento di prova
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}