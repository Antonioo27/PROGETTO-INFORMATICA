package com.example.provadefinitiva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GestioneGiocatoriController implements Initializable {

    @FXML
    private Button buttonConferma;

    @FXML
    private Button buttonElimina;

    @FXML
    private Button buttonGiocatore;

    @FXML
    private Button buttonTornaIndietro;

    @FXML
    private ListView<String> listView=new ListView<String>();


    @FXML
    private Label labelVisualizzaGiocatore;

    @FXML
    private TextField textNuovoGiocatore;
    private Stage stage;
    private Scene scene;

    private ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
    ArrayList<String> nomi = new ArrayList<String>();


    @FXML
    void confermaGiocatore(ActionEvent event) throws FileNotFoundException {
        String nomeNuovo = "";
        String nomeVecchio = "";
                    if(textNuovoGiocatore.getText().length()>0) {
                        PrintWriter scrivo = new PrintWriter(new File("LeaderBoardFile.csv"));
                        nomeNuovo = textNuovoGiocatore.getText();
                        nomeVecchio=labelVisualizzaGiocatore.getText();
                        nomi.remove(nomeVecchio);
                        nomi.add(nomeNuovo);
                        for (int i = 0; i < giocatori.size(); i++) {
                           if(giocatori.get(i).getUsername().equalsIgnoreCase(nomeVecchio)){
                               listView.setItems(FXCollections.observableArrayList(nomi));
                               giocatori.get(i).setUsername(nomeNuovo);
                           }
                            scrivo.println(giocatori.get(i).getUsername() + "," + giocatori.get(i).getTotalScore());
                        }
                        scrivo.close();
                        labelVisualizzaGiocatore.setText("");
                        textNuovoGiocatore.setVisible(false);
                        buttonConferma.setVisible(false);
                        textNuovoGiocatore.setText("");
                    }
                    else
                        Allert.showAlert(Alert.AlertType.INFORMATION, "Nome non valido", "Devi inserire un nome prima");

    }

    @FXML
    void eliminaGiocatore(ActionEvent event) throws FileNotFoundException {

        if (labelVisualizzaGiocatore.getText().length() == 0) {
                Allert.showAlert(Alert.AlertType.INFORMATION, "Errore", "Non puoi eliminare un giocatore inesistente");
            } else {
                Giocatore giocatore = new Giocatore(labelVisualizzaGiocatore.getText(), 0);
                PrintWriter scrivo = new PrintWriter(new File("LeaderBoardFile.csv"));

                for (int i = 0; i < giocatori.size(); i++) {
                    if (giocatore.getUsername().equalsIgnoreCase(giocatori.get(i).getUsername())) {
                        nomi.remove(giocatore.getUsername());
                        giocatori.remove(i);
                        listView.setItems(FXCollections.observableArrayList(nomi));
                    }
                }
                for (int i = 0; i < giocatori.size(); i++)
                    scrivo.println(giocatori.get(i).getUsername() + "," + giocatori.get(i).getTotalScore());

                scrivo.close();

                labelVisualizzaGiocatore.setText("");
            }
        }


    @FXML
    void modificaGiocatore(ActionEvent event) {
        if(labelVisualizzaGiocatore.getText().length()>0) {
            textNuovoGiocatore.setVisible(true);
            buttonConferma.setVisible(true);
        }else
            Allert.showAlert(Alert.AlertType.INFORMATION, "Errore", "Non puoi modificare un giocatore inesistente");


    }

    @FXML
    void tornaIndietro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonConferma.setVisible(false);
            Scanner scan = null;
            try {
                scan = new Scanner(new File("LeaderBoardFile.csv"));
            } catch (FileNotFoundException e) {
                System.out.print("File non trovato");
            }
            while (scan.hasNextLine()) {
                String riga = scan.nextLine();
                String[] str = riga.split(",");
                giocatori.add(new Giocatore(str[0], Integer.parseInt(str[1])));
            }
            for (int i = 0; i < giocatori.size(); i++)
                nomi.add(giocatori.get(i).getUsername());
        if (nomi.size() == 1) {
            labelVisualizzaGiocatore.setText(nomi.get(0));
            listView.setItems(FXCollections.observableArrayList(nomi));
        } else {
            listView.setItems(FXCollections.observableArrayList(nomi));
        }
    }


    public void selezionaGiocatore(MouseEvent mouseEvent) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if(newValue != null) {
                       labelVisualizzaGiocatore.setText(newValue);
                    }
           });
      }
}


