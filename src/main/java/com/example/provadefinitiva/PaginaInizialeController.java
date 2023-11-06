package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;




import java.io.IOException;

public class PaginaInizialeController {

    private Stage stage;
    private Scene scene;

    public void loginAdministrator(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AmministratoreLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Pagina Iniziale");
        stage.show();
    }

    public void loginPlayer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginGiocatore.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void viewRegole(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Regole.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

