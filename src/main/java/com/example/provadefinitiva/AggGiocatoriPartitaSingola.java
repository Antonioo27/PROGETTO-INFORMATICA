package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.*;
import java.util.ArrayList;

public class AggGiocatoriPartitaSingola {

    @FXML
    private ChoiceBox<?> ChoiceBox;

    @FXML
    private Button aggiungi_button;

    @FXML
    private TextField giocatore_textField;

    @FXML
    private Label labelCodicePartita;

    @FXML
    private Label labelGiocatori;
    private Stage stage;
    private Scene scene;
    private Parent root;


    private Mazzo mazzo=new Mazzo();
    private ArrayList<String> nomiGiocatori=new ArrayList<String>();

    @FXML
   public void aggiungiGiocatore(ActionEvent event) throws IOException {

        FileWriter writer = new FileWriter(labelCodicePartita.getText()+".csv",true);
        PrintWriter scrivo = new PrintWriter(writer);

        if(giocatore_textField.getText()!=null){
           Giocatore player = new Giocatore(giocatore_textField.getText(),this.mazzo);
           this.nomiGiocatori.add(giocatore_textField.getText());
           scrivo.print(player.toString());
           giocatore_textField.setText("");
        }
        scrivo.close();
    }


    @FXML
    public void logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("PagIniziale.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
   public void visualizzaGiocatori(ActionEvent event) {
      labelGiocatori.setText(nomiGiocatori.toString());
    }

    public void visualizzaCodicePartita(String codicePartita) throws IOException {
        labelCodicePartita.setText(codicePartita);
    }

    public ArrayList<String> getNomiGiocatori(){
        return this.nomiGiocatori;
    }
}
