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
    private Button AggiungiButton;

    @FXML
    private Button ProseguiButton;
    ArrayList<String> nomi=new ArrayList<String>();

    public void aggiungiUtente(ActionEvent event) throws IOException {

        String codiceControllo = codicePartitaField.getText()+".csv";
        File file = new File(codiceControllo);
        if(file.exists()) {
            Scanner scan=new Scanner(file);
            while (scan.hasNextLine()){
                String riga= scan.nextLine();
                String[] strings=riga.split(","); //Creare tasto salva partita una volta entrati nel gioco, e magari prima nella creazione della partita salvare solamente i nomi dei giocatori e non punteggio e carte
                nomi.add(strings[0]);

            }

            if(nomi.contains(usernameField.getText())) {
                System.out.println("il nome è presente");
                System.out.println(nomi.get(0).toString());
            }
            else
                System.out.println("il nome non è sulla lista");
        }else
            labelMsg.setText("Codice partita non valido");
    }


    public void InizializzaGiocatori(ActionEvent event) throws IOException {

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
