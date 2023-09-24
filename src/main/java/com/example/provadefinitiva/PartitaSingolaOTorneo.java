package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class PartitaSingolaOTorneo {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label loginLabel;

    private String codicePartita;

    public void displayName(String username){
        loginLabel.setText("Benvenuto :"+username);
    }

    public void creaPartitaSingola(ActionEvent event) throws IOException {

        String codicePartita = String.valueOf((int)(Math.random() * (3000 - 2000 + 1) + 2000));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AggiungiNomi.fxml"));
        root= loader.load();
        AggGiocatoriPartitaSingola aggiungiNomiController = loader.getController();
        aggiungiNomiController.visualizzaCodicePartita(codicePartita);
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
          stage.setScene(scene);
          Image icon = new Image("C:\\Users\\HP\\ProvaDefinitiva\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\logo.png");
          stage.getIcons().add(icon);
          stage.show();
    }


    public void creaTorneo(ActionEvent event) throws IOException {

        String codicePartita = String.valueOf((int)(Math.random() * (2000 - 1000 + 1) + 1000));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AggiungiNomi.fxml"));
        root= loader.load();
        AggGiocatoriPartitaSingola aggiungiNomiController = loader.getController();
        aggiungiNomiController.visualizzaCodicePartita(codicePartita);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        Image icon = new Image("C:\\Users\\HP\\ProvaDefinitiva\\src\\main\\resources\\com\\example\\provadefinitiva\\Immagini\\logo.png");
        stage.getIcons().add(icon);
        stage.show();
    }
}
