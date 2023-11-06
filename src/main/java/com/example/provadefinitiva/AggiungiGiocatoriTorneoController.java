package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class AggiungiGiocatoriTorneoController {

    @FXML
    private Label LBLv1;

    @FXML
    private Label LBLv1_1;

    @FXML
    private Label LBLv1_2;

    @FXML
    private Label LBLv1_3;

    @FXML
    private Label LBLv2;

    @FXML
    private Label LBLv2_1;

    @FXML
    private Label LBLv2_2;

    @FXML
    private Label LBLv2_3;

    @FXML
    private Label LBLv3;

    @FXML
    private Label LBLv3_1;

    @FXML
    private Label LBLv3_2;

    @FXML
    private Label LBLv3_3;

    @FXML
    private TextField TxtF1_1_1;

    @FXML
    private TextField TxtF1_1_2;

    @FXML
    private TextField TxtF1_1_3;

    @FXML
    private TextField TxtF1_2_1;

    @FXML
    private TextField TxtF1_2_2;

    @FXML
    private TextField TxtF1_2_3;

    @FXML
    private TextField TxtF1_3_1;

    @FXML
    private TextField TxtF1_3_2;

    @FXML
    private TextField TxtF1_3_3;

    @FXML
    private TextField TxtF2_1_1;

    @FXML
    private TextField TxtF2_1_2;

    @FXML
    private TextField TxtF2_1_3;

    @FXML
    private TextField TxtF2_2_1;

    @FXML
    private TextField TxtF2_2_2;

    @FXML
    private TextField TxtF2_2_3;

    @FXML
    private TextField TxtF2_3_1;

    @FXML
    private TextField TxtF2_3_2;

    @FXML
    private TextField TxtF2_3_3;

    @FXML
    private TextField TxtF3_1_1;

    @FXML
    private TextField TxtF3_1_2;

    @FXML
    private TextField TxtF3_1_3;

    @FXML
    private TextField TxtF3_2_1;

    @FXML
    private TextField TxtF3_2_2;

    @FXML
    private TextField TxtF3_2_3;

    @FXML
    private TextField TxtF3_3_1;

    @FXML
    private TextField TxtF3_3_2;

    @FXML
    private TextField TxtF3_3_3;

    @FXML
    private Label LblCodiceTorneo;


    private Stage stage;
    private Scene scene;

    private ArrayList<String> nomiGiocatori=new ArrayList<String>();
    private MainEngine m = new MainEngine();


    @FXML
    void creaTorneo(ActionEvent event) throws IOException {

        ArrayList<TextField> campiGiocatoriTorneo = new ArrayList<TextField>();
        campiGiocatoriTorneo.addAll(Arrays.asList(TxtF1_1_1,TxtF2_1_1,TxtF3_1_1, TxtF1_2_1,TxtF2_2_1,TxtF3_2_1,TxtF1_3_1,TxtF2_3_1,TxtF3_3_1,TxtF1_1_2,TxtF2_1_2,TxtF3_1_2,TxtF1_2_2,TxtF2_2_2,TxtF3_2_2,TxtF1_3_2,TxtF2_3_2,TxtF3_3_2,TxtF1_1_3,TxtF2_1_3,TxtF3_1_3,TxtF1_2_3,TxtF2_2_3,TxtF3_2_3,TxtF1_3_3,TxtF2_3_3,TxtF3_3_3));

        for(int i=0; i<campiGiocatoriTorneo.size(); i++){
            nomiGiocatori.add(campiGiocatoriTorneo.get(i).getText());
        }

        //Riempimento della partita con dei bot
        int botCount=1;
        for(int i=0; i<nomiGiocatori.size(); i++){
            if(nomiGiocatori.get(i).length()==0){
                nomiGiocatori.set(i,"bot"+botCount);
           botCount++;
            }
        }

        File file = new File("PartiteETornei.csv");
        if(file.exists()){
            FileWriter fw = new FileWriter(file,true);
            fw.append(LblCodiceTorneo.getText()+System.lineSeparator());
            fw.close();
        }
        else{
            PrintWriter pw=new PrintWriter(file);
            pw.println(LblCodiceTorneo.getText());
            pw.close();
        }

        for(int i=0; i<this.nomiGiocatori.size(); i++)
            new ModificaLeaderBoard().aggiungiGiocatoreLeaderBoard(this.nomiGiocatori.get(i));

        m.creaQuarti(nomiGiocatori, LblCodiceTorneo.getText());

        for(int i=0; i<9; i++){
            m.getPartitaTorneo(i).salvaPartita();
        }

        PrintWriter scrivo = new PrintWriter(LblCodiceTorneo.getText()+".csv");
        for(int i=0; i<9; i++){
           scrivo.println(m.getPartitaTorneo(i).getCodice());
        }

        scrivo.close();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root=loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void visualizzaCodiceTorneo(String codicePartita) {
        LblCodiceTorneo.setText(codicePartita);
    }

    public void tornaAllaHome(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root=loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

