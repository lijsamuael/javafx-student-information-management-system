package com.example.student_information_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;


public class SignINController {
    @FXML
    private Button btnlogin;

    @FXML
    private TextField txtprd;

    @FXML
    private TextField txtun;
    @FXML
    private Label lblerror;
    @FXML
    private Label hhh;

    @FXML
    void login(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        String b = txtprd.getText();

        System.out.println(b);
        /*
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
                    count++;
                    break;

                }

            }
            if(count == 0) {
                lblerror.setText("Incorrect password or username");

            }

        }
*/
    }




    }


