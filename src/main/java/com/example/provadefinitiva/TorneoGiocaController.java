package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class TorneoGiocaController{

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
    private Label Lbl1_1_1;

    @FXML
    private Label Lbl1_1_2;

    @FXML
    private Label Lbl1_1_3;

    @FXML
    private Label Lbl1_2_1;

    @FXML
    private Label Lbl1_2_2;

    @FXML
    private Label Lbl1_2_3;

    @FXML
    private Label Lbl1_3_1;

    @FXML
    private Label Lbl1_3_2;

    @FXML
    private Label Lbl1_3_3;

    @FXML
    private Label Lbl2_1_1;

    @FXML
    private Label Lbl2_1_2;

    @FXML
    private Label Lbl2_1_3;

    @FXML
    private Label Lbl2_2_1;

    @FXML
    private Label Lbl2_2_2;

    @FXML
    private Label Lbl2_2_3;

    @FXML
    private Label Lbl2_3_1;

    @FXML
    private Label Lbl2_3_2;

    @FXML
    private Label Lbl2_3_3;

    @FXML
    private Label Lbl3_1_1;

    @FXML
    private Label Lbl3_1_2;

    @FXML
    private Label Lbl3_1_3;

    @FXML
    private Label Lbl3_2_1;

    @FXML
    private Label Lbl3_2_2;

    @FXML
    private Label Lbl3_2_3;

    @FXML
    private Label Lbl3_3_1;

    @FXML
    private Label Lbl3_3_2;

    @FXML
    private Label Lbl3_3_3;

    @FXML
    private Label LblCodiceTorneo;
    @FXML
    private Button buttonGiocaQuarti1;

    @FXML
    private Button buttonGiocaQuarti2;

    @FXML
    private Button buttonGiocaQuarti3;

    @FXML
    private Button buttonGiocaQuarti5;

    @FXML
    private Button buttonGiocaQuarti6;

    @FXML
    private Button buttonGiocaQuarti7;

    @FXML
    private Button buttonGiocaQuarti8;

    @FXML
    private Button buttonGiocaQuarti9;

    private Stage stage;
    private Scene scene;

    private File fileTorneo;

    private MainEngine m = new MainEngine();


    @FXML
    void buttonGioca1(ActionEvent event) {

    }

    @FXML
    void buttonGioca1_1(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(0);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.caricaFileTorneo(fileTorneo);
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void buttonGioca1_2(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(1);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.caricaFileTorneo(fileTorneo);
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        if(partita.getVincitore()!=null)
            buttonGiocaQuarti2.setVisible(false);
    }

    @FXML
    void buttonGioca1_3(ActionEvent event) {

    }

    @FXML
    void buttonGioca2(ActionEvent event) {

    }

    @FXML
    void buttonGioca2_1(ActionEvent event) {

    }

    @FXML
    void buttonGioca2_2(ActionEvent event) {

    }

    @FXML
    void buttonGioca2_3(ActionEvent event) {

    }

    @FXML
    void buttonGioca3(ActionEvent event) {

    }

    @FXML
    void buttonGioca3_1(ActionEvent event) {

    }

    @FXML
    void buttonGioca3_2(ActionEvent event) {

    }

    @FXML
    void buttonGioca3_3(ActionEvent event) {

    }

    @FXML
    void buttonGiocaFinale(ActionEvent event) {

    }

    public File getfile(){
        return fileTorneo;
    }



    public void caricaQuarti(File file) throws FileNotFoundException {
        fileTorneo = file;
        m.caricaTorneo(file);
        System.out.println(m.getPartiteTorneo().size());
        ArrayList<Label> labelArrayList = new ArrayList<>();

        labelArrayList.addAll(Arrays.asList(Lbl1_1_1,Lbl2_1_1,Lbl3_1_1,Lbl1_2_1,Lbl2_2_1,Lbl3_2_1,Lbl1_3_1,Lbl2_3_1,Lbl3_3_1,Lbl1_1_2,Lbl2_1_2,Lbl3_1_2,Lbl1_2_2,Lbl2_2_2,Lbl3_2_2,Lbl1_3_2,Lbl2_3_2,Lbl3_3_2,Lbl1_1_3,Lbl2_1_3,Lbl3_1_3,Lbl1_2_3,Lbl2_2_3,Lbl3_2_3,Lbl1_3_3,Lbl2_3_3,Lbl3_3_3));

        int indiceGiocatore=0;
        int indicePartitaTorneo=0;
        for(int i=2; i<labelArrayList.size(); i=i+3) {
            if (m.getPartitaTorneo(indicePartitaTorneo).getVincitore() == null) {  //per settare label di partite non ancora finite
                labelArrayList.get(i - 2).setText(m.getPartitaTorneo(indicePartitaTorneo).getGiocatori().get(indiceGiocatore).getUsername());
                indiceGiocatore++;
                labelArrayList.get(i - 1).setText(m.getPartitaTorneo(indicePartitaTorneo).getGiocatori().get(indiceGiocatore).getUsername());
                indiceGiocatore++;
                labelArrayList.get(i).setText(m.getPartitaTorneo(indicePartitaTorneo).getGiocatori().get(indiceGiocatore).getUsername());
                indiceGiocatore = 0;
                indicePartitaTorneo++;
            }else{


            }
        }
    }



    public void visualizzaCodiceTorneo(String codice) {
        LblCodiceTorneo.setText(codice);
    }

    public void aggiornaTorneoFront(File fileTorneoo) {




    }
}


