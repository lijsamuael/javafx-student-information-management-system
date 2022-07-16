package com.example.student_information_management_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stud_controller implements Initializable  {
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

    @FXML
    private TableView<Grade> gratable;

    @FXML
    private TableColumn<Grade,Integer> col100;

    @FXML
    private TableColumn<Grade,Integer> col15;

    @FXML
    private TableColumn<Grade,Integer> col15_2;

    @FXML
    private TableColumn<Grade,Integer> col20;

    @FXML
    private TableColumn<Grade,Integer> col50;

    @FXML
    private TableColumn<Grade,String> colcourse;

    @FXML
    private TableColumn<course, Character> colgrade;

    @FXML
    private TableColumn<course, Integer> colcode;

    @FXML
    private TableColumn<course, Integer> colcrhr;

    @FXML
    private TableColumn<course, String> colinst;

    @FXML
    private TableColumn<course, Integer> colsemister;

    @FXML
    private TableColumn<course, String> columcourse;

    @FXML
    private TableColumn<course, Character> columgrade;

    @FXML
    private TableColumn<course, Integer> colyear;

    @FXML
    private TableView<course> cortable;
    URL url;
    ResourceBundle resourceBundle;

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
            txttitle.setText("ABOUT");
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
            initialize( url,  resourceBundle);
            txttitle.setText("STUDENT PROFILE");
            propane.toFront();
        }

    }
    ObservableList<Grade> list= FXCollections.observableArrayList();
    ObservableList<course> list2= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");

            ResultSet Gr =  con.createStatement().executeQuery("select * from grade");
            ResultSet Co =  con.createStatement().executeQuery("select * from course");

            while (Gr.next()){
                list.add(
                        new Grade(Gr.getString("Course"),
                                Gr.getInt("Quiz"),
                                Gr.getInt("Assignment"),
                                Gr.getInt("Mid"),
                                Gr.getInt("Final"),
                                Gr.getInt("Total"),
                                Gr.getString("Grade")));}
            while (Co.next()){
                list2.add(
                        new course(Co.getString("Course"),
                                Co.getString("Instructor"),
                                Co.getInt("Cr_Hr"),
                                Co.getInt("Course_Code"),
                                Co.getInt("Year"),
                                Co.getInt("Semister"),
                                Co.getString("Grade")));

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        colcourse.setCellValueFactory(new PropertyValueFactory<Grade, String>("course"));
        col15.setCellValueFactory(new PropertyValueFactory<Grade, Integer>("s_15_1"));
        col15_2.setCellValueFactory(new PropertyValueFactory<Grade, Integer>("s_15_2"));
        col20.setCellValueFactory(new PropertyValueFactory<Grade, Integer>("s_20"));
        col50.setCellValueFactory(new PropertyValueFactory<Grade, Integer>("s_50"));
        col100.setCellValueFactory(new PropertyValueFactory<Grade, Integer>("s_100"));
        colgrade.setCellValueFactory(new PropertyValueFactory<course, Character>("Letter"));
        gratable.setItems(list);

        colcode.setCellValueFactory(new PropertyValueFactory<course, Integer>("code"));
        colcrhr.setCellValueFactory(new PropertyValueFactory<course, Integer>("crhr"));
        colyear.setCellValueFactory(new PropertyValueFactory<course, Integer>("year"));
        colsemister.setCellValueFactory(new PropertyValueFactory<course, Integer>("semister"));
        colinst.setCellValueFactory(new PropertyValueFactory<course, String>("instructor"));
        columcourse.setCellValueFactory(new PropertyValueFactory<course, String>("course"));
        columgrade.setCellValueFactory(new PropertyValueFactory<course, Character>("grade"));
        cortable.setItems(list2);
    }
}
