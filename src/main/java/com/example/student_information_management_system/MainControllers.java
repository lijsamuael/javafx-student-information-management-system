package com.example.student_information_management_system;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
    @FXML
    private Button btnlogin;

    @FXML
    private Label lblerror;

    @FXML
    private TextField txtpassword;

    @FXML
    private TextField txtusername;

    @FXML
    private TextField txtemails;

    @FXML
    private TextField txtpasswords;

    @FXML
    private TextField txtusernames;

    @FXML
    private Button btnsignups;

    @FXML
    private Label lblerror2;



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
                fxml = FXMLLoader.load(getClass().getResource("SignUP.fxml"));
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

    @FXML
    void login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        if(txtusername.getText() == "" || txtpassword.getText() == "") {

            lblerror.setText("One or more fieds are empty");

        }
        else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from registration");
            int count = 0;

            while(rs.next()) {
                if( txtusername.getText().equals(rs.getString("username")) && txtpassword.getText().equals(rs.getString("password"))) {

                    lblerror.setText("Successfull login");
                    Stage stage = (Stage) btnlogin.getScene().getWindow();
                    stage.close();
                    Stage adminpage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                    adminpage.setScene(new Scene(root, 1355, 768));

                    adminpage.show();
                    count++;
                    break;

                }

            }
            if(count == 0) {
                lblerror.setText("Incorrect password or username");

            }

        }

    }
    @FXML
    public void signup(ActionEvent event) throws ClassNotFoundException, SQLException {

        if( txtusernames.getText() == "" || txtemails.getText() == "" || txtpasswords.getText() == ""  ) {
            lblerror2.setText("One or more fileds are empty");
        }

        else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from account");
            //
            int count = 0;
            int countr = 0;
            while(rs.next()) {
                if(  txtusernames.getText().equals(rs.getString("id"))) {
                    count++;
                    break;
                }
            }
            if(count == 0) {
                lblerror2.setText("It seems you are not the member of the university.\nPlease contact the admin");
            }
            else {

                ResultSet rss = stmt.executeQuery("select *from registration");

                while(rss.next()) {
                    if(txtusernames.getText().equals(rss.getString("username"))) {
                        lblerror2.setText("A student with that username already exists.");
                        countr++;
                    }
                }

                if(countr == 0) {
                    String query = "INSERT INTO `registration` (`username`, `email`, `password`) VALUES (?, ?, ?)";
                    PreparedStatement prs = con.prepareStatement(query);
                    prs.setString(1, txtusernames.getText());
                    prs.setString(2, txtemails.getText());
                    prs.setString(3, txtpasswords.getText());
                    prs.executeUpdate();
                    lblerror2.setText("You have Signed up successfully.\nPress sign i button to login");

                }


            }

        }



    }

}
