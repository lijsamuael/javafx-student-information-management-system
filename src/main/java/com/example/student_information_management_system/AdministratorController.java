package com.example.student_information_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class AdministratorController {

    @FXML
    private Button btnaaddstudent;

    @FXML
    private Button btnadd;

    @FXML
    private Button btndatabase;

    @FXML
    private Button btnddeletestudent;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnhome;

    @FXML
    private Button btnsearch;

    @FXML
    private Button btnssearch;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnuupdatestudent;

    @FXML
    private Label idbatch;

    @FXML
    private Label lblubatch;

    @FXML
    private Label lbludept;

    @FXML
    private Label lblufname;

    @FXML
    private Label lblulname;

    @FXML
    private Label lblusex;

    @FXML
    private TextField txtabatch;

    @FXML
    private TextField txtadept;

    @FXML
    private TextField txtafname;

    @FXML
    private TextField txtaid;

    @FXML
    private TextField txtalname;

    @FXML
    private TextField txtasex;

    @FXML
    private TextField txtdsearch;

    @FXML
    private TextField txtssearch;

    @FXML
    private Label txttitle;

    @FXML
    private TextField txtubatch;

    @FXML
    private TextField txtudept;

    @FXML
    private TextField txtufname;

    @FXML
    private TextField txtulname;

    @FXML
    private TextField txtusearch;

    @FXML
    private TextField txtusex;

    @FXML
    private VBox vadd;

    @FXML
    private VBox vdatabase;

    @FXML
    private VBox vdelete;

    @FXML
    private VBox vhome;

    @FXML
    private VBox vsearch;

    @FXML
    private VBox vupdate;

    @FXML
    void addStudent(ActionEvent event) {

    }

    @FXML
    void clickOn(ActionEvent event) {

        if(event.getSource() == btnhome)
        {
            txttitle.setText("ADMINSTRATOR PAGE");
            vhome.toFront();

        }
        else if(event.getSource() == btnadd)
        {
            txttitle.setText("ADDING STUDENT RECORDS");
            vadd.toFront();
        }
        else if(event.getSource() == btnupdate)
        {
            txttitle.setText("UPDATE STUDENT RECORDS");
            vupdate.toFront();
        }
        else if(event.getSource() == btnsearch)
        {
            txttitle.setText("SEARCH STUDENTS");
            vsearch.toFront();
        }
        else if(event.getSource() == btndatabase)
        {
            txttitle.setText("ALL STUDENTS LIST");

            vdatabase.toFront();
        }
        else if(event.getSource() == btndelete)
        {
            txttitle.setText("DELETE A STUDENT");

            vdelete.toFront();
        }


    }

    @FXML
    void deleteStudent(ActionEvent event) {

    }

    @FXML
    void searchStudent(ActionEvent event) {

    }

    @FXML
    void updateStudent(ActionEvent event) {

    }

}
