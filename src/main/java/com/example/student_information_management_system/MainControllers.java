package com.example.student_information_management_system;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainControllers {

    @FXML
    private Button btngotosignin;

    @FXML
    private Button btngotosignup;

    @FXML
    private Label haveanaccount;

    @FXML
    private Label nothaveanaccount;

    @FXML
    private Pane pnlgotosignin;

    @FXML
    private Pane pnlgotosignup;

    @FXML
    private VBox vbox;

    Parent fxml;




    @FXML
    private void initialize(URL rul, ResourceBundle rb) {


    }

    @FXML
    private void open_signup(ActionEvent e) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setByX(249);
        t.play();
        t.setOnFinished((ee) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("Signup.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            } catch (IOException er) {
                System.out.println(er);
            }
        });
        pnlgotosignup.setVisible(false);
        pnlgotosignin.setVisible(true);


    }

    @FXML
    private void open_signin(ActionEvent e) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(2), vbox);
        t.setByX(-249);
        t.play();
        t.setOnFinished((eee) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("Login.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            } catch (IOException er) {
                System.out.println(er);
            }
        });
        pnlgotosignin.setVisible(false);
        pnlgotosignup.setVisible(true);

    }
}
