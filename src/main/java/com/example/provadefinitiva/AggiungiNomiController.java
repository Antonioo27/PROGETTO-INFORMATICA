package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class AggiungiNomiController {
   @FXML
   private TextField giocatore_textField;
   private ArrayList<String>giocatori = new ArrayList<String>() ;


    public void aggiungiGiocatore(ActionEvent event) {

        if (giocatore_textField.getText() != null) {
            giocatori.add(giocatore_textField.getText());
            System.out.println(giocatori);
            giocatore_textField.setText("");
        }
    }
}
