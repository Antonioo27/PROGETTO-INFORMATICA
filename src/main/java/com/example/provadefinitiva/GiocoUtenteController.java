package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GiocoUtenteController {
    @FXML
    private Label labelGiocatore1;
    @FXML
    private Label labelGiocatore2;
    @FXML
    private Label labelGiocatore3;
    @FXML
    private Label labelGiocatore4;
    @FXML
    private Label labelCodicePartita;
    @FXML
    private Button giocaButton;


    public void aggiungiGiocatori(ArrayList<String> nomeGiocatore) throws IOException {
        if(nomeGiocatore.size()==4) {
            labelGiocatore1.setText(nomeGiocatore.get(0));
            labelGiocatore2.setText(nomeGiocatore.get(1));
            labelGiocatore1.setText(nomeGiocatore.get(2));
            labelGiocatore2.setText(nomeGiocatore.get(3));
        }
        else if(nomeGiocatore.size()==3){
            labelGiocatore1.setText(nomeGiocatore.get(0));
            labelGiocatore2.setText(nomeGiocatore.get(1));
            labelGiocatore1.setText(nomeGiocatore.get(2));
        }
        else if(nomeGiocatore.size()==2){
            labelGiocatore1.setText(nomeGiocatore.get(0));
            labelGiocatore2.setText(nomeGiocatore.get(1));
        }
        else
            labelGiocatore1.setText(nomeGiocatore.get(0));

    }

    public void visualizzaCodicePartita(String codicePartita) {
        labelCodicePartita.setText(codicePartita);
        labelCodicePartita.setTextFill(Color.RED);
    }

    public void gioca(ActionEvent event) {
        giocaButton.setDisable(true);
        giocaButton.setVisible(false);
        labelGiocatore1.setBorder(Border.stroke(Color.RED));

    }





}
