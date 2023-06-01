package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AggiungiNomiController {
   @FXML
   private TextField giocatore_textField;
   @FXML
   private Label labelGiocatori;
    @FXML
    private Label labelCodicePartita;
   private ArrayList<String>giocatori = new ArrayList<String>() ;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void visualizzaCodicePartita(String codicePartita) throws FileNotFoundException {
        labelCodicePartita.setText("Codice Partita : "+codicePartita);
        PrintWriter scrivo = new PrintWriter("Partita.txt");
          scrivo.println(codicePartita);
          scrivo.close();
    }
    public void aggiungiGiocatore(ActionEvent event) throws IOException, FileNotFoundException {
        FileWriter scrivo = new FileWriter("Partita.txt",true);
        PrintWriter scrivoveramente = new PrintWriter(scrivo);

        if (giocatore_textField.getText() != null) {
            giocatori.add(giocatore_textField.getText());
            scrivoveramente.println(giocatore_textField.getText());
            System.out.println(giocatori);
            giocatore_textField.setText("");
        }
        scrivo.close();
    }

    public void visualizzaGiocatori(ActionEvent event) {
          labelGiocatori.setText(String.valueOf(giocatori));
    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PaginaIniziale.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        Image icon = new Image("C:\\Users\\HP\\ProvaDefinitiva\\src\\logo.png");
        stage.getIcons().add(icon);
        stage.show();
    }



}
