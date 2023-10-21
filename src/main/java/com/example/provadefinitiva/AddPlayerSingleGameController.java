package com.example.provadefinitiva;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddPlayerSingleGameController implements Initializable {

    @FXML
    private ChoiceBox<String> ChoiceBox;

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
    private ArrayList<String> nomiGiocatori = new ArrayList<String>();
    private ArrayList<String> stringheChoicebox = new ArrayList<>();


    @FXML
    public void aggiungiGiocatore(ActionEvent event) throws IOException {

            if (giocatore_textField.getText().length()>0) {
                if (!(giocatore_textField.getText().equalsIgnoreCase("bot0")) || !(giocatore_textField.getText().equalsIgnoreCase("bot1")) || !(giocatore_textField.getText().equalsIgnoreCase("bot2"))) {
                    if (nomiGiocatori.contains(giocatore_textField.getText())==false)
                        this.nomiGiocatori.add(giocatore_textField.getText());
                    else
                        Allert.showAlert(Alert.AlertType.INFORMATION, "Nome non valido", "Non puoi inserire lo stesso nome due volte ");
                }
                else {
                    Allert.showAlert(Alert.AlertType.INFORMATION, "Nome non valido", "Non puoi inserire un giocatore con questo nome ");
                }
            }
            else
                Allert.showAlert(Alert.AlertType.INFORMATION, "Errore", "Inserisci nome del giocatore ");

            giocatore_textField.setText("");
             if(nomiGiocatori.size()==3) {
                aggiungi_button.setDisable(true);
                giocatore_textField.setText("");
                giocatore_textField.setDisable(true);
            }
            String visualizzaGiocatori = "";

            for(int i=0; i<this.nomiGiocatori.size(); i++)
                visualizzaGiocatori = visualizzaGiocatori+"\n"+(i+1)+")" + nomiGiocatori.get(i);

            labelGiocatori.setText(visualizzaGiocatori);
    }


    @FXML
    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void visualizzaCodicePartita(String codicePartita) throws IOException {
        labelCodicePartita.setText(codicePartita);
    }

    public void createSingleGame(ActionEvent event) throws IOException {
        for(int i=0; i<this.nomiGiocatori.size(); i++)
        new ModificaLeaderBoard().aggiungiGiocatoreLeaderBoard(this.nomiGiocatori.get(i));
        switch(nomiGiocatori.size()){
            case(0) : nomiGiocatori.addAll(Arrays.asList("bot1","bot2", "bot3"));
            case(1) : nomiGiocatori.addAll(Arrays.asList("bot1","bot2"));
            case(2) : nomiGiocatori.addAll(Arrays.asList("bot1"));
        }
        MainEngine.creaPartita(this.nomiGiocatori, labelCodicePartita.getText());
        Parent root = FXMLLoader.load(getClass().getResource("PagIniziale.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Scanner scan = null;
        labelGiocatori.setText("");
        File file = new File("LeaderBoardFile.csv");

        if (!file.exists())
            ChoiceBox = new ChoiceBox<>();
        else {
        try {
            scan = new Scanner(file);
        }catch(FileNotFoundException e){
            e.toString();
         }
            while (scan != null && scan.hasNextLine()) {
                String riga = scan.nextLine();
                String[] str = riga.split(",");
                stringheChoicebox.add(str[0]);
            }
            ChoiceBox.getItems().addAll(stringheChoicebox);
            ChoiceBox.getSelectionModel().selectFirst();

            ChoiceBox.setOnMouseClicked(event -> {
                giocatore_textField.setText(ChoiceBox.getValue());
            });
        }
    }


}


