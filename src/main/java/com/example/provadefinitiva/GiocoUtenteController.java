package com.example.provadefinitiva;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GiocoUtenteController {
    @FXML
    private Label labelGiocatore1;
    @FXML
    private Label labelCodicePartita;


    public void aggiungiGiocatore(String nomeGiocatore) {
        labelGiocatore1.setText(nomeGiocatore);
        labelGiocatore1.setTextFill(Color.RED);

    }

    public void visualizzaCodicePartita(String codicePartita) {
        labelCodicePartita.setText(codicePartita);
        labelCodicePartita.setTextFill(Color.RED);
    }


}
