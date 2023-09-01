package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GiocatoreLoginController   {

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
        Scanner scan = new Scanner(new File("Partita.txt"));
        scan.nextLine();
        String codicePartita = scan.nextLine();
        while (scan.hasNextLine()) {
            String username = scan.next();
            int score = Integer.parseInt(scan.next());
            nomi.add(username);

            Giocatore g1 = new Giocatore(username, score);
            String user=usernameField.getText();
            if (nomi.contains(user) && codicePartitaField.getText().equalsIgnoreCase(codicePartita)) {
                giocatori.add(g1);
                labelMsg.setText("Giocatore presente sulla lista.");
                labelMsg.setTextFill(Color.GREEN);
                usernameField.setText("");
                break;
            } else {
                labelMsg.setText("Mi dispiace ma non sei sulla lista");
                labelMsg.setTextFill(Color.RED);
                usernameField.setText("");
            }
        }

    }


    public void InizializzaGiocatori(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GiocoUtente.fxml"));
        root = loader.load();
        GiocoUtenteController giocoUtenteController = loader.getController();
        giocoUtenteController.aggiungiGiocatori(giocatori);
        giocoUtenteController.visualizzaCodicePartita(codicePartitaField.getText());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("GIOCHIAMO");
        stage.show();
    }


}
