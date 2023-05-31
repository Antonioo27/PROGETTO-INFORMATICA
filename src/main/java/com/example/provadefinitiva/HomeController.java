package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Text codPartita_text;
    @FXML
    private Label loginLabel;

    public void displayName(String username){
        loginLabel.setText("Benvenuto :"+username);
    }

    public void creaPartita(ActionEvent event) throws IOException {
        codPartita_text.setText("Codice Partita : "+String.valueOf((int)(Math.random()*10000)));
          Parent root = FXMLLoader.load(getClass().getResource("AggiungiNomi.fxml"));
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
          stage.setScene(scene);
          Image icon = new Image("C:\\Users\\HP\\ProvaDefinitiva\\src\\logo.png");
          stage.getIcons().add(icon);
          stage.show();
    }


}
