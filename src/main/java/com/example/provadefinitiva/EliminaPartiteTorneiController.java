package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class EliminaPartiteTorneiController implements Initializable {
    @FXML
    private Button buttonElimina;

    @FXML
    private Label labelVisualizzaPartitaTorneo;

    @FXML
    private ListView<?> listView;

    public void eliminaPartitaTorneo(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
