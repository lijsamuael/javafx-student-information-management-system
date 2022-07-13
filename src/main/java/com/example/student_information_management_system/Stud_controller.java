package com.example.student_information_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Stud_controller {
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
    private VBox coursepan;

    @FXML
    private VBox dirpane;

    @FXML
    private VBox propane;

    @FXML
    private VBox settpane;

    @FXML
    private VBox gradepan;
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
