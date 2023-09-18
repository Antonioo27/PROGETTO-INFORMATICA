package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AggiungiGiocatoriController {
    @FXML
    private TextField giocatore_textField;
    @FXML
    private Label labelGiocatori;
    @FXML
    private Label labelCodicePartita;
    @FXML
    private ChoiceBox<String> ChoiceBox;
   private ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>() ;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void initialize() throws FileNotFoundException {
        File file = new File("GiocatoriVecchi.txt");
        if(file.exists()) {
            Scanner scan = new Scanner(new File("GiocatoriVecchi.txt"));
            ArrayList<String> giocatori = new ArrayList<String>();
            while (scan.hasNext()) {

                String gioc = scan.next();
                giocatori.add(gioc);
            }
            ChoiceBox.getItems().addAll(giocatori);
            ChoiceBox.setValue(giocatori.get(0));
            ChoiceBox.setOnAction(event -> {
                String selezione = ChoiceBox.getValue();
                giocatore_textField.setText(selezione);
            });
        }
    }


    public void visualizzaCodicePartita(String codicePartita) throws FileNotFoundException {
        labelCodicePartita.setText("Codice Partita : "+codicePartita);
        PrintWriter scrivo = new PrintWriter("Partita.txt");
         scrivo.println("USERNAME     SCORE ");
          scrivo.println(codicePartita);
          scrivo.close();
    }
    public void aggiungiGiocatore(ActionEvent event) throws IOException, FileNotFoundException {
        FileWriter partita = new FileWriter("Partita.txt",true);
        PrintWriter scrivoPartita = new PrintWriter(partita);

        //file writer per creare file per giocatori gia inseriti in passato.
        FileWriter giaScritti = new FileWriter("GiocatoriVecchi.txt",true);
        PrintWriter scrivoGiocatoriVecchi = new PrintWriter(giaScritti);



        if (giocatore_textField.getText() != null) {
            Giocatore player=new Giocatore(giocatore_textField.getText());
            giocatori.add(new Giocatore(giocatore_textField.getText()));
            scrivoPartita.print(player.toString());
          
            //Non inserisco giocatori doppioni, cioe con stesso nome
            Scanner scan = new Scanner(new File("GiocatoriVecchi.txt"));
            boolean condizione = true;
           while(scan.hasNextLine()) {
               String nome = scan.nextLine();
               if(giocatore_textField.getText().equalsIgnoreCase(nome)){
                   condizione = false;
               }
           }
           if(condizione==true) {
               scrivoGiocatoriVecchi.println(giocatore_textField.getText());
           }
            giocatore_textField.setText("");
        }
        scrivoGiocatoriVecchi.close();
        scrivoPartita.close();
    }

    public void visualizzaGiocatori(ActionEvent event) {

        labelGiocatori.setText(String.valueOf(giocatori));
    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PagIniziale.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
