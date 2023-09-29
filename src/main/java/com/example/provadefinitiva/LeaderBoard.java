package com.example.provadefinitiva;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class LeaderBoard {

    @FXML
    private TableView<Giocatore> TableView;

    @FXML
    private TableColumn<Giocatore, String> username;

    @FXML
    private TableColumn<Giocatore, Integer> totalScore;
    @FXML
    private Button openNewWindow;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private ArrayList<Giocatore> GIOCATORI = new ArrayList<Giocatore>();

    //Metodo che prende i Giocatori che hanno fatto il login e una volta premuto il pulsante leaderBoard li inserisce dentro
    //Da fare : costruire un file dove salvare la leaderboard ogni volta.
    public void prendiGiocatori(ArrayList<Giocatore> Giocatori){
        for(int i=0; i<Giocatori.size(); i++){
            Giocatore g=Giocatori.get(i);
            if(g.getUsername().equalsIgnoreCase("Bot1")||g.getUsername().equalsIgnoreCase("Bot2"))
               Giocatori.remove(i);
        }

        GIOCATORI.addAll(Giocatori);
        ObservableList<Giocatore> listaGiocatori = FXCollections.observableArrayList(GIOCATORI);
        username.setCellValueFactory(new PropertyValueFactory<Giocatore, String>("username"));
        totalScore.setCellValueFactory(new PropertyValueFactory<Giocatore, Integer>("totalScore"));

        TableView.setItems(listaGiocatori);
    }

    /*public void backPartita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LeaderBoard.fxml"));
         root = loader.load();
        Partita partita = loader.getController();
        partita.carica(partita.getCodice()+".csv");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("LEADERBOARD");
        stage.show();


    }

     */

    @FXML
    private void openNewWindow(ActionEvent event) throws Exception {
        Partita partita = new Partita();
        partita.openNewWindow();
    }
}
