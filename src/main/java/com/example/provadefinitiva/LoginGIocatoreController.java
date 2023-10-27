package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginGIocatoreController {


    @FXML
    private TextField codicePartitaField;
    @FXML
    private TextField codiceTorneoField1;


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button CaricaPartitaButton;


    public void IniziaPartita(ActionEvent event) throws IOException {

        String codiceControllo = codicePartitaField.getText()+".csv";
        File file = new File(codiceControllo);
        if(file.exists()) {
            Scanner scan = new Scanner(file);
                if(scan.nextLine().charAt(0)=='.'){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Partita.fxml"));
                    root = loader.load();
                    PartitaController partitaController = loader.getController();
                    partitaController.carica(file);
                    partitaController.visualizzaCodicePartita();
                    if(Integer.parseInt(codiceControllo.substring(0,4))< 2000)
                        partitaController.setCodiceTorneo(codiceControllo.substring(0,4));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("GIOCHIAMO");
                    stage.show();
                }
        }
        else
            Allert.showAlert(Alert.AlertType.INFORMATION, "Errore", "Codice partita non valido");

    }


    public void iniziaTorneo(ActionEvent event) throws IOException {

        String codiceControllo = codiceTorneoField1.getText()+".csv";
        File file = new File(codiceControllo);
        if(file.exists()) {
            Scanner scan = new Scanner(file);
            if(scan.hasNextLine()){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TorneoGioca.fxml"));
                root = loader.load();
                TorneoGiocaController torneoGiocaController = loader.getController();
                torneoGiocaController.setFile(codiceControllo.substring(0,4));
                torneoGiocaController.visualizzaCodiceTorneo(codiceControllo);
                torneoGiocaController.inizializza();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("GIOCHIAMO");
                stage.show();
            }
        }
        else
            Allert.showAlert(Alert.AlertType.INFORMATION, "Errore", "Codice torneo non valido");
    }
   @FXML
    public void tornaIndietro(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("PaginaIniziale.fxml"));
        scene =new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Pagina iniziale");
        stage.show();
   }
}
