package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AggiungiNomiController {
   @FXML
   private TextField giocatore_textField;
   private ArrayList<String>giocatori = new ArrayList<String>() ;


    public void aggiungiGiocatore(ActionEvent event) throws IOException, FileNotFoundException {
        FileWriter scrivo = new FileWriter("Giocatori.txt",true);
        PrintWriter scrivoveramente = new PrintWriter(scrivo);

        if (giocatore_textField.getText() != null) {
            giocatori.add(giocatore_textField.getText());
            scrivoveramente.println(giocatore_textField.getText());
            System.out.println(giocatori);
            giocatore_textField.setText("");
        }
    }
}
