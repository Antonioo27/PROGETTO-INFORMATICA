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
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;

import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

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
    private ArrayList<Giocatore> Giocatori = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void aggiungiGiocatori(ArrayList<Giocatore> giocatori) throws IOException {
      Giocatori.addAll(giocatori);
        if(giocatori.size()==4) {
            labelGiocatore1.setText(giocatori.get(0).getUsername()+"\n"+giocatori.get(0).getTotalScore());
            labelGiocatore2.setText(giocatori.get(1).getUsername()+"\n"+giocatori.get(1).getTotalScore());
            labelGiocatore1.setText(giocatori.get(2).getUsername()+"\n"+giocatori.get(2).getTotalScore());
            labelGiocatore2.setText(giocatori.get(3).getUsername()+"\n"+giocatori.get(3).getTotalScore());
        }
        else if(giocatori.size()==3){
            labelGiocatore1.setText(giocatori.get(0).getUsername()+"\n"+giocatori.get(0).getTotalScore());
            labelGiocatore2.setText(giocatori.get(1).getUsername()+"\n"+giocatori.get(1).getTotalScore());
            labelGiocatore1.setText(giocatori.get(2).getUsername()+"\n"+giocatori.get(2).getTotalScore());
        }
        else if(giocatori.size()==2){
            labelGiocatore1.setText(giocatori.get(0).getUsername()+"\n"+giocatori.get(0).getTotalScore());
            labelGiocatore2.setText(giocatori.get(1).getUsername()+"\n"+giocatori.get(1).getTotalScore());
        }
        else
            labelGiocatore1.setText(giocatori.get(0).getUsername()+"\n"+giocatori.get(0).getTotalScore());

    }

    public void visualizzaCodicePartita(String codicePartita) {
        labelCodicePartita.setText(codicePartita);
        labelCodicePartita.setTextFill(Color.RED);
    }

    public void gioca(ActionEvent event) {
        giocaButton.setDisable(true);
        giocaButton.setVisible(false);
        Gioca gioco = new Gioca( Giocatori);

        labelGiocatore1.setStyle("-fx-background-color: WHITE;-fx-border-color:RED ;-fx-border-width: 3px;");

    }


    public void vaiAllaLeaderboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LeaderBoard.fxml"));
        root= loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        LeaderBoardController leaderBoardController = loader.getController();
        leaderBoardController.prendiGiocatori(Giocatori);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
