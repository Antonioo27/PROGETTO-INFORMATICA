package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Partita {

    public Button ButtonSalvaPartita;
    @FXML
    private Label Giocatore1Score;

    @FXML
    private Label Giocatore2Score;

    @FXML
    private Label Giocatore3Score;

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

    public Partita() throws Exception {
    }

    @FXML
    void gioca(ActionEvent event) {

    }

    @FXML
    public void vaiAllaLeaderboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LeaderBoard.fxml"));
        root = loader.load();
        LeaderBoard leaderBoard = loader.getController();
        leaderBoard.prendiGiocatori(giocatori);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("LEADERBOARD");
        stage.show();
    }

    public void inizia(ArrayList<String> nomi) {
        if(nomi.size()==3){
            for(int i=0; i<nomi.size(); i++){
                Giocatore g=new Giocatore(nomi.get(i),mazzo);
                giocatori.add(g);
            }
        } else if (nomi.size() == 2) {
            for (int i = 0; i < nomi.size(); i++) {
                Giocatore g = new Giocatore(nomi.get(i), mazzo);
                giocatori.add(g);
            }
            Giocatore bot1 = new Giocatore("Bot1",mazzo);
            giocatori.add(bot1);
        } else {
            for (int i = 0; i < nomi.size(); i++) {
                Giocatore g = new Giocatore(nomi.get(i), mazzo);
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

    public void SalvaPartita() throws IOException {
        PrintWriter scrivo = new PrintWriter(labelCodicePartita.getText() + ".csv");
        scrivo.println(".");
        scrivo.println(mazzo.toString() + "\n");

        for(int i=0; i<giocatori.size(); i++)
            scrivo.println(giocatori.get(i).toString());
        }
        scrivo.close();
    }

    public void carica(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        Mazzo nuovo = new Mazzo();
        scan.nextLine();

        String[] RimanenzeFile = scan.nextLine().split(",");

        LinkedList<Carta> mazzoRimanente = new LinkedList<Carta>();
        System.out.println(RimanenzeFile.length);
            for (int i = 0; i < RimanenzeFile.length-1; i++) {
                System.out.println("1");
                for (int j = 0; j < nuovo.getMazzo().size(); j++) {
                    Carta c = nuovo.getMazzo().get(j);
                    if (c.getNome().equalsIgnoreCase(RimanenzeFile[i])) {
                        System.out.println("hai inserito "+c.getNome());
                        mazzoRimanente.add(c);
                        nuovo.getMazzo().remove(c);
                        break;
                    }
                }
            }

            this.mazzo.setMazzo(mazzoRimanente);
            scan.nextLine();
            while(scan.hasNextLine()) {
                String s = scan.nextLine();
                if (s != "") {
                    String[] str = s.split(",");
                    ArrayList<Carta> mano = new ArrayList<Carta>();
                    for (int i = 2; i < str.length; i++) {
                        for (int j = 0; j < nuovo.getMazzo().size(); j++) {
                            Carta c = nuovo.getMazzo().get(j);
                            if (c.getNome().equalsIgnoreCase(str[i])) {
                                mano.add(c);
                            }
                        }
                    }
                    this.giocatori.add(new Giocatore(str[0], Integer.parseInt(str[1]), mano));
                }
            }
                labelGiocatore1.setText(giocatori.get(0).getUsername());
                Giocatore1Score.setText("" + giocatori.get(0).getTotalScore());

                labelGiocatore2.setText(giocatori.get(1).getUsername());
                Giocatore2Score.setText("" + giocatori.get(1).getTotalScore());

                labelGiocatore3.setText(giocatori.get(2).getUsername());
                Giocatore3Score.setText("" + giocatori.get(2).getTotalScore());
                System.out.println("Numero giocatori"+giocatori.size());
                System.out.println("Mazzo da cui prendere carte"+nuovo.getMazzo().size());
                System.out.println("Mazzo del game "+this.mazzo.getMazzo().size());


               System.out.println("Carte del primo giocatore "+giocatori.get(0).getCarte().size());


    }

}