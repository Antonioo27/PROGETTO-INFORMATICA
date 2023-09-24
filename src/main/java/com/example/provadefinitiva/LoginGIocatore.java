package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginGIocatore {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField codicePartitaField;

    @FXML
    private Label labelMsg;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();

    @FXML
    private Button CaricaPartitaButton;

    ArrayList<String> nomi = new ArrayList<String>();


    public void IniziaPartita(ActionEvent event) throws IOException {

        String codiceControllo = codicePartitaField.getText()+".csv";
        File file = new File(codiceControllo);
        if(file.exists()) {
            Scanner scan2 = new Scanner(file);
            Scanner scan = new Scanner(file);
                if(scan.nextLine().charAt(0)=='.'){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Partita.fxml"));
                    root = loader.load();
                    Partita partita = loader.getController();
                    partita.carica(file);
                    partita.visualizzaCodicePartita(codicePartitaField.getText());
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("GIOCHIAMO");
                    stage.show();
                }
                else{

                    while(scan2.hasNextLine()){
                        String string = scan2.nextLine();
                        nomi.add(string);
                    }

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Partita.fxml"));
                    root = loader.load();
                    Partita partita = loader.getController();
                    partita.inizia(nomi);
                    partita.visualizzaCodicePartita(codicePartitaField.getText());
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("GIOCHIAMO");
                    stage.show();

                }

        }
        else
            labelMsg.setText("codice non valido");


    }



}
