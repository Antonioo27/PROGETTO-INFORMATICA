package com.example.provadefinitiva;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EliminaPartiteTorneiController implements Initializable {
    @FXML
    private Button buttonElimina;

    @FXML
    private Label labelVisualizzaPartitaTorneo;

    @FXML
    private ListView<String> listView;
    private Scene scene;
    private Stage stage;
    private ArrayList<String> codici=new ArrayList<String>();

    public void eliminaPartitaTorneo(ActionEvent event) throws FileNotFoundException {
        if(labelVisualizzaPartitaTorneo.getText().length()>0){
            String delete=labelVisualizzaPartitaTorneo.getText();
            if(Integer.parseInt(labelVisualizzaPartitaTorneo.getText())>=3000) {//torneo
                File file=new File(delete+".csv");
                Scanner scan=new Scanner(file);
                while(scan.hasNextLine()){
                    String filePath=scan.nextLine();
                    try {
                        File file2 = new File(filePath+".csv");

                        if (file2.delete()) {
                            System.out.println("File eliminato con successo.");
                        } else {
                            System.out.println("Impossibile eliminare il file. Controlla che esista e che tu abbia le autorizzazioni necessarie.");
                        }
                    } catch (Exception e) {
                        System.err.println("Si è verificato un errore durante l'eliminazione del file: " + e.getMessage());
                    }
                }
                scan.close();
                System.out.println(file.delete()?"file eliminato":"Non eliminato");

                codici.remove(codici.indexOf(delete));
                listView.setItems(FXCollections.observableArrayList(codici));
            }
            else if(Integer.parseInt(labelVisualizzaPartitaTorneo.getText())<3000 && Integer.parseInt(labelVisualizzaPartitaTorneo.getText())>=2000){//partita singola

                try {
                    File file = new File(delete+".csv");

                    if (file.delete()) {
                        System.out.println("File eliminato con successo.");
                    } else {
                        System.out.println("Impossibile eliminare il file. Controlla che esista e che tu abbia le autorizzazioni necessarie.");
                    }
                } catch (Exception e) {
                    System.err.println("Si è verificato un errore durante l'eliminazione del file: " + e.getMessage());
                }
                codici.remove(codici.indexOf(delete));
                listView.setItems(FXCollections.observableArrayList(codici));
            } else
                Allert.showAlert(Alert.AlertType.INFORMATION, "codice non valido", "Il codice della partita che hai inserito è inesistente\n"+"oppure non corrisponde ad una partita singola o un torneo");
        }else
            Allert.showAlert(Alert.AlertType.INFORMATION, "Errore", "Devi prima selezionare il codice da eliminare");

        PrintWriter pw=new PrintWriter(new File("PartiteETornei.csv"));
        for(int i=0; i<codici.size(); i++)
            pw.println(codici.get(i));
        pw.close();
        labelVisualizzaPartitaTorneo.setText("");
    }
    public void selezionaCodice(MouseEvent mouseEvent) {

        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        labelVisualizzaPartitaTorneo.setText(newValue);
                    }
                });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file=new File("PartiteETornei.csv");

        Scanner scan=null;
        if(file.exists()){
            try {
                scan = new Scanner(file);
            }catch(FileNotFoundException e){
                System.out.println(e.toString());
            }
            while(scan.hasNextLine())
                codici.add(scan.nextLine());
            listView.setItems(FXCollections.observableArrayList(codici));
            if(codici.size()>0)
                labelVisualizzaPartitaTorneo.setText(codici.get(0));
        }
    }
    public void tornaIndietro(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("PAGINA INIZIALE");
        stage.show();
}
}