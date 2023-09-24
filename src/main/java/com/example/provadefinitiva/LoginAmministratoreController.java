package com.example.provadefinitiva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginAmministratoreController {
    @FXML
    private Text loginMsg;
    @FXML
    private PasswordField passwordLogin;
    @FXML
    private TextField username_field;


    private String password = "admin";
    private String username="admin";
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void checkLogin(ActionEvent event) throws IOException {
        String username = username_field.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        root= loader.load();

        PartitaSingolaOTorneo homeController = loader.getController();
        homeController.displayName(username);

        if(passwordLogin.getText().equals(this.password) && username_field.getText().equalsIgnoreCase(username)){
            loginMsg.setText("Login succesful");
            loginMsg.setFill(Color.GREEN);
            //Andiamo nella home
             // Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
              stage = (Stage)((Node)event.getSource()).getScene().getWindow();
              scene = new Scene(root);
              stage.setScene(scene);
              stage.setTitle("HOME PAGE");
              stage.show();
        }
        else {
            loginMsg.setText("Did you forget your password ?");
            loginMsg.setFill(Color.LIGHTSEAGREEN);
        }

    }

    public void clearLogin(ActionEvent event) {
        passwordLogin.setText("");
        username_field.setText("");
    }
}