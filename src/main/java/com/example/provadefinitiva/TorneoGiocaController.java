package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.*;


public class TorneoGiocaController   {

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
    private Button buttonGiocaQuarti4;

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
    @FXML
    private Button buttonGiocaSemi1;
    @FXML
    private Button buttonGiocaSemi2;
    @FXML
    private Button buttonGiocaSemi3;
    @FXML
    private Button buttonGiocaFinale;

    private Stage stage;
    private Scene scene;

    private File fileTorneo;

    private MainEngine m = new MainEngine();

    ArrayList<Label> labelArrayList =  new ArrayList<>();



    @FXML
    void buttonGioca1(ActionEvent event) {

    }

    @FXML
    void buttonGioca1_1(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(0);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void buttonGioca2_1(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(1);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonGioca3_1(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(2);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void buttonGioca1_2(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(3);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonGioca2_2(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(4);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void buttonGioca3_2(ActionEvent event) throws IOException{
        Partita partita = m.getPartitaTorneo(5);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void buttonGioca1_3(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(6);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void buttonGioca2_3(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(7);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void buttonGioca3_3(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(8);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void buttonGiocaSemi1(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(9);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void buttonGiocaSemi2(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(10);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void buttonGiocaSemi3(ActionEvent event) throws IOException {
        Partita partita = m.getPartitaTorneo(11);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Partita.fxml"));
        Parent root=loader.load();
        PartitaController partitaController = loader.getController();
        partitaController.setCodiceTorneo(LblCodiceTorneo.getText());
        partitaController.carica(new File(partita.getCodice()+".csv"));
        partitaController.visualizzaCodicePartita();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonGiocaFinale(ActionEvent event) throws IOException{

    }

    public File getfile(){
        return fileTorneo;
    }

    public void setFile(String file){
        this.fileTorneo = new File(file+".csv");
    }

    public void caricaQuarti() throws IOException {
        boolean quartiFiniti=true;

          for(int i=0; i<m.getPartiteTorneo().size(); i++) {
              if (m.getPartitaTorneo(i).getVincitore() == null)
                  quartiFiniti = false;
              else {
                  switch (i) {
                      case (0): {
                          LBLv1_1.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                          this.buttonGiocaQuarti1.setVisible(false);
                          break;
                      }
                      case (1): {
                          LBLv2_1.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                          this.buttonGiocaQuarti2.setVisible(false);
                          break;
                      }
                      case (2): {
                          LBLv3_1.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                          this.buttonGiocaQuarti3.setVisible(false);
                          break;
                      }
                      case (3): {
                          LBLv1_2.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                          this.buttonGiocaQuarti4.setVisible(false);
                          break;
                      }
                      case (4): {
                          LBLv2_2.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                          this.buttonGiocaQuarti5.setVisible(false);
                          break;
                      }
                      case (5): {
                          LBLv3_2.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                          this.buttonGiocaQuarti6.setVisible(false);
                          break;
                      }
                      case (6): {
                          LBLv1_3.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                          this.buttonGiocaQuarti7.setVisible(false);
                          break;
                      }
                      case (7): {
                          LBLv2_3.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                          this.buttonGiocaQuarti8.setVisible(false);
                          break;
                      }
                      case (8): {
                          LBLv3_3.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                          this.buttonGiocaQuarti9.setVisible(false);
                          break;
                      }
                  }
              }
          }
             /* if(quartiFiniti==true) {
                  try {
                      this.caricaSemi();
                  } catch (IOException e) {
                      throw new RuntimeException(e);
                  }
              }

              */
        ArrayList<Label> labelSemi = new ArrayList<Label>();
        labelSemi.addAll(Arrays.asList(LBLv1_1,LBLv2_1,LBLv3_1,LBLv1_2,LBLv2_2,LBLv3_2,LBLv1_3,LBLv2_3,LBLv3_3));


        boolean temp = true;
              for(int i=0; i<labelSemi.size(); i++){
                  if(labelSemi.get(i).getText().equalsIgnoreCase(""))
                      temp = false;
              }

              if(temp == true)
                  caricaSemi();



    }

    private void caricaSemi() throws IOException {
      buttonGiocaSemi1.setVisible(true);
      buttonGiocaSemi2.setVisible(true);
      buttonGiocaSemi3.setVisible(true);

      ArrayList<String> semifinalisti = new ArrayList<String>();
      for(int i=0; i<m.getPartiteTorneo().size(); i++) {
          if(m.getPartiteTorneo().get(i).getVincitore().getUsername()!= null)
         semifinalisti.add(m.getPartiteTorneo().get(i).getVincitore().getUsername());
      }
      m.creaSemifinali(semifinalisti,this.LblCodiceTorneo.getText());
        for(int i=0; i<m.getPartiteTorneo().size(); i++){
            m.getPartitaTorneo(i).salvaPartita();
        }
      PrintWriter scrivo = new PrintWriter(new File(this.LblCodiceTorneo.getText()+".csv"));
         for(int i=0; i<m.getPartiteTorneo().size(); i++){
             scrivo.println(m.getPartitaTorneo(i).getCodice());
         }
         scrivo.close();

        boolean semiFinite=true;

        for(int i=9; i<m.getPartiteTorneo().size(); i++) {
            if (m.getPartitaTorneo(i).getVincitore() == null)
                semiFinite = false;
            else {
                switch (i) {
                    case (9): {
                        LBLv1.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                        this.buttonGiocaSemi1.setVisible(false);
                        break;
                    }
                    case (10): {
                        LBLv2.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                        this.buttonGiocaSemi2.setVisible(false);
                        break;
                    }
                    case (11): {
                        LBLv3.setText(m.getPartitaTorneo(i).getVincitore().getUsername());
                        this.buttonGiocaSemi3.setVisible(false);
                        break;
                    }
                    }
                }
            }
        if(semiFinite==true) {
            this.caricaFinale();
        }

    }

    private void caricaFinale() {
        buttonGiocaFinale.setVisible(true);

    }


    public void visualizzaCodiceTorneo(String codice) {
        LblCodiceTorneo.setText(codice.substring(0,4));
    }


    public void inizializza() throws IOException {
        try {
            m.caricaTorneo(this.fileTorneo);
        }catch(IOException e) {
        e.getMessage();
        }
        labelArrayList.addAll(Arrays.asList(Lbl1_1_1,Lbl2_1_1,Lbl3_1_1,Lbl1_2_1,Lbl2_2_1,Lbl3_2_1,Lbl1_3_1,Lbl2_3_1,Lbl3_3_1,Lbl1_1_2,Lbl2_1_2,Lbl3_1_2,Lbl1_2_2,Lbl2_2_2,Lbl3_2_2,Lbl1_3_2,Lbl2_3_2,Lbl3_3_2,Lbl1_1_3,Lbl2_1_3,Lbl3_1_3,Lbl1_2_3,Lbl2_2_3,Lbl3_2_3,Lbl1_3_3,Lbl2_3_3,Lbl3_3_3));

        int indiceGiocatore=0;
        int indicePartitaTorneo=0;
        for(int i=2; i<labelArrayList.size(); i=i+3) {
            //per settare label di partite non ancora finite
                labelArrayList.get(i - 2).setText(m.getPartitaTorneo(indicePartitaTorneo).getGiocatori().get(indiceGiocatore).getUsername());
                indiceGiocatore++;
                labelArrayList.get(i - 1).setText(m.getPartitaTorneo(indicePartitaTorneo).getGiocatori().get(indiceGiocatore).getUsername());
                indiceGiocatore++;
                labelArrayList.get(i).setText(m.getPartitaTorneo(indicePartitaTorneo).getGiocatori().get(indiceGiocatore).getUsername());
                indiceGiocatore = 0;
                indicePartitaTorneo++;
            }
        this.caricaQuarti();
        }


}



