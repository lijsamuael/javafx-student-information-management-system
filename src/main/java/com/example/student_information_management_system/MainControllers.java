package com.example.student_information_management_system;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainControllers implements Initializable {

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
    private Parent fxml;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.5), vbox);
        t.setByX(-124.5);
        t.play();
        t.setOnFinished((eee) -> {
            try {
                 fxml = FXMLLoader.load(getClass().getResource("SignIN.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            } catch (IOException error) {

            }
        });

    }

    @FXML
    private void open_signup(ActionEvent e) throws IOException {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.5), vbox);
        t.setByX(249);
        t.play();
        t.setOnFinished((eee) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("SignIN.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            } catch (IOException error) {

            }
        });

    }

    @FXML
    private void open_signin(ActionEvent e) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1.5), vbox);
        t.setByX(-249);
        t.play();
        t.setOnFinished((eee) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("SignIN.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            } catch (IOException error) {

            }
        });
    }

}
