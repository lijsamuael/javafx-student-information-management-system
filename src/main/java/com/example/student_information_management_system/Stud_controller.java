package com.example.student_information_management_system;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Stud_controller implements Initializable {
    @FXML
    private Button btncourses;

    @FXML
    private Button btndirector;

    @FXML
    private Button btngrade;

    @FXML
    private Button btnprofile;

    @FXML
    private Button btnsetting;

    @FXML
    private Label txttitle;
    @FXML
    private Label lblaskualaheading;

    @FXML
    private Label idbatch;

    @FXML
    private Label iddept;

    @FXML
    private Label idid;

    @FXML
    private Label idname;

    @FXML
    private VBox coursepan;

    @FXML
    private VBox dirpane;

    @FXML
    private VBox propane;

    @FXML
    private VBox settpane;

    @FXML
    private VBox gradepan;

    @Override
    public void initialize(URL url, ResourceBundle rb)  {

        TranslateTransition t = new TranslateTransition(Duration.seconds(10), lblaskualaheading);
        t.setByX(-1000);
       // t.play();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
            MainControllers mc = new MainControllers();
            String studid = mc.renderid;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from account");
            while(rs.next()) {
                if(  studid.equals(rs.getString("id"))) {
                    idname.setText(rs.getString("fname") + "   " + rs.getString("lname"));
                    iddept.setText(rs.getString("department"));
                    idid.setText(rs.getString("id"));
                    idbatch.setText(String.valueOf(rs.getInt("batch")));
                    break;
                }
            }
            System.out.println("abebe beso bela");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    private void clickOn(ActionEvent event)
    {
        if(event.getSource() == btncourses)
        {
            txttitle.setText("STUDENT COURSES");
            coursepan.toFront();

        }
        else if(event.getSource() == btnsetting)
        {
            txttitle.setText("SETTING");
            settpane.toFront();
        }
        else if(event.getSource() == btndirector)
        {
            txttitle.setText("DIRECTOR");
            dirpane.toFront();
        }
        else if(event.getSource() == btngrade)
        {
            txttitle.setText("STUDENT GRADE");
            gradepan.toFront();
        }
        else if(event.getSource() == btnprofile)
        {
            txttitle.setText("STUDENT PROFILE");

            propane.toFront();
        }

    }
}
