package com.example.provadefinitiva;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class LeaderBoardController implements Initializable {

    @FXML
    private TableView<Giocatore> TableView;

    @FXML
    private TableColumn<Giocatore, String> username;

    @FXML
    private TableColumn<Giocatore, Integer> totalScore;
     ObservableList<Giocatore> listaGiocatori = FXCollections.observableArrayList(
             new Giocatore("Cavallo",500)
             );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setCellValueFactory(new PropertyValueFactory<Giocatore, String>("username"));
        totalScore.setCellValueFactory(new PropertyValueFactory<Giocatore, Integer>("totalScore"));

        TableView.setItems(listaGiocatori);
    }
}
