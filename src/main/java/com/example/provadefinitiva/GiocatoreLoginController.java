package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GiocatoreLoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField codicePartitaField;

    @FXML
    private Label labelMsg;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private ArrayList<String> giocatori = new ArrayList<String>();


    public void aggiungiUtente(ActionEvent event) throws IOException {
        Scanner scan = new Scanner(new File("C:\\Users\\HP\\ProvaDefinitiva\\Partita.txt"));
         int count=0;
         String codicePartita="";
          while(scan.hasNext()){
              if(count==0){
                  codicePartita= scan.next();
              }
             String giocatore = scan.next();
             if(usernameField.getText().equalsIgnoreCase(giocatore) && codicePartitaField.getText().equalsIgnoreCase(codicePartita)){
                  giocatori.add(giocatore);
                  labelMsg.setText("Giocatore presente sulla lista.");
                  labelMsg.setTextFill(Color.GREEN);
                  break;
             }
              else{
                 labelMsg.setText("Mi dispiace ma non sei sulla lista");
                  labelMsg.setTextFill(Color.RED);
             }
            count++;
          }
    }


    public void InizializzaGiocatori(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GiocoUtente.fxml"));
        root = loader.load();
        GiocoUtenteController giocoUtenteController = loader.getController();
        giocoUtenteController.aggiungiGiocatori(giocatori);
        giocoUtenteController.visualizzaCodicePartita(codicePartitaField.getText());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("GIOCHIAMO");
        stage.show();
    }
}
