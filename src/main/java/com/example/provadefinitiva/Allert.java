package com.example.provadefinitiva;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.stage.Screen;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

public class Allert {

    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }







        }

