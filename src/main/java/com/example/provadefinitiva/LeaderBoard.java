package com.example.provadefinitiva;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;


public class LeaderBoard {

    @FXML
    private TableView<Giocatore> TableView;

    @FXML
    private TableColumn<Giocatore, String> username;

    @FXML
    private TableColumn<Giocatore, Integer> totalScore;

    private ArrayList<Giocatore> GIOCATORI = new ArrayList<>();

    //Metodo che prende i Giocatori che hanno fatto il login e una volta premuto il pulsante leaderBoard li inserisce dentro
    //Da fare : costruire un file dove salvare la leaderboard ogni volta.
    public void prendiGiocatori(ArrayList<Giocatore> Giocatori){

        GIOCATORI.addAll(Giocatori);
        ObservableList<Giocatore> listaGiocatori = FXCollections.observableArrayList(GIOCATORI);
        username.setCellValueFactory(new PropertyValueFactory<Giocatore, String>("username"));
        totalScore.setCellValueFactory(new PropertyValueFactory<Giocatore, Integer>("totalScore"));

        TableView.setItems(listaGiocatori);
    }

}
