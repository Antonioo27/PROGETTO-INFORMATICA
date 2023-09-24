package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;

public class Partita {

    public Button ButtonSalvaPartita;
    @FXML
    private Label Giocatore1Score;

    @FXML
    private Label Giocatore2Score;

    @FXML
    private Label Giocatore3Score;

    @FXML
    private Label Giocatore4Score;

    @FXML
    private Button giocaButton;

    @FXML
    private Label labelCodicePartita;

    @FXML
    private Label labelGiocatore1;

    @FXML
    private Label labelGiocatore2;

    @FXML
    private Label labelGiocatore3;

    @FXML
    private Label labelGiocatore4;
    private Mazzo mazzo=new Mazzo();

    private ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();

    @FXML
    void gioca(ActionEvent event) {

    }

    @FXML
    void vaiAllaLeaderboard(ActionEvent event) {

    }

    public void inizia(ArrayList<String> nomi) {
        if(nomi.size()==3){
            for(int i=0; i<nomi.size(); i++){
                Giocatore g=new Giocatore(nomi.get(i),mazzo);
                giocatori.add(g);
            }


        }else if(nomi.size()==2){
            for(int i=0; i<nomi.size(); i++) {
                Giocatore g = new Giocatore(nomi.get(i),mazzo);
                giocatori.add(g);
            }
            Giocatore bot1 = new Giocatore("Bot1",mazzo);
            giocatori.add(bot1);
        }
            else if (nomi.size()==1) {
            for(int i=0; i<nomi.size(); i++) {
                Giocatore g = new Giocatore(nomi.get(i),mazzo);
                giocatori.add(g);
            }
            Giocatore bot1 = new Giocatore("Bot1",mazzo);
            Giocatore bot2 = new Giocatore("Bot2",mazzo);
            giocatori.add(bot1);
            giocatori.add(bot2);

        }
        labelGiocatore1.setText(giocatori.get(0).getUsername());
        Giocatore1Score.setText(""+giocatori.get(0).getTotalScore());

        labelGiocatore2.setText(giocatori.get(1).getUsername());
        Giocatore2Score.setText(""+giocatori.get(1).getTotalScore());

        labelGiocatore3.setText(giocatori.get(2).getUsername());
        Giocatore3Score.setText(""+giocatori.get(2).getTotalScore());

    }

    public void visualizzaCodicePartita(String text) {
        labelCodicePartita.setText(text);
    }

    public void SalvaPartita () throws IOException {
        FileWriter writer = new FileWriter(labelCodicePartita.getText()+".csv",true);
        PrintWriter scrivo = new PrintWriter(writer);

        scrivo.println(mazzo.toString());

        for(int i=0; i<giocatori.size(); i++)
            scrivo.println(giocatori.get(i).toString());
    }

}