package com.example.student_information_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class adminController implements Initializable {

    @FXML
    private Button btnaddstudent;

    @FXML
    private Button btndeletstudent;

    @FXML
    private Button btnhome;

    @FXML
    private Button btnlogout;

    @FXML
    private Button btnopenadd;

    @FXML
    private Button btnopendelete;

    @FXML
    private Button btnopenretrieve;

    @FXML
    private Button btnopenupdate;

    @FXML
    private Button btnretrivestudent;

    @FXML
    private Button btnupdatestudent;

    @FXML
    private TextField delid;

    @FXML
    private TextField inage;

    @FXML
    private TextField inbatch;

    @FXML
    private TextField indept;

    @FXML
    private TextField infname;

    @FXML
    private TextField inid;

    @FXML
    private TextField inlname;

    @FXML
    private TextField insex;

    @FXML
    private TextField rtid;

    @FXML
    private TextField upage;

    @FXML
    private TextField upbatch;

    @FXML
    private TextField updept;

    @FXML
    private TextField upfname;

    @FXML
    private TextField upid;

    @FXML
    private TextField uplname;

    @FXML
    private TextField upsex;
    @Override
    public void initialize(URL url, ResourceBundle rb){

    }
    @FXML
    void add(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(inid.equals("") || infname.equals("") || infname.equals("") || inlname.equals("") || insex.equals("") || indept.equals("") || indept.equals("")){
            Alert a = new Alert(Alert.AlertType.WARNING, "One or more empty fileds are empty");
        }
        else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
            String query = "INSERT INTO `account`  VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prs = con.prepareStatement(query);
            prs.setString(1, inid.getText());
            prs.setString(2, infname.getText());
            prs.setString(3, inlname.getText());
            prs.setString(4, insex.getText());
            prs.setString(5, indept.getText());
            prs.setInt(6, Integer.parseInt(inbatch.getText()));
            prs.executeUpdate();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "YOU HAVE SUCCESSFULY ADD A STUDENT");
            a.show();
        }
    }

    @FXML
    void delet(ActionEvent event) throws ClassNotFoundException, SQLException {
       // DELETE FROM `account` WHERE id = 1
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
        String query = "DELETE FROM account WHERE id = ?";
        PreparedStatement prs = con.prepareStatement(query);
        prs.setString(1,delid.getText());
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "ARE YOU SURE TO DELETE");
        a.show();
        prs.executeUpdate();
        Alert aa = new Alert(Alert.AlertType.INFORMATION, "You have successfuly delet the student");
        a.show();




    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void retrieve(ActionEvent event) {

    }

    @FXML
    void studadd(ActionEvent event) {

    }

    @FXML
    void studdelete(ActionEvent event) {

    }

    @FXML
    void studupdate(ActionEvent event) {

    }

    @FXML
    void sudretrieve(ActionEvent event) {

    }

    @FXML
    void tohome(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(inid.equals("") || infname.equals("") || infname.equals("") || inlname.equals("") || insex.equals("") || indept.equals("") || indept.equals("")){
            Alert a = new Alert(Alert.AlertType.WARNING, "One or more empty fileds are empty");
        }
        else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
            Statement st = con.createStatement();
            String query = "UPDATE `account` SET `fname`= ?,`lname`= ?,`sex`= ?,`department`= ?,`batch`= ? WHERE id = ?";
            PreparedStatement prs = con.prepareStatement(query);
            ResultSet rs = st.executeQuery("select * from account");
            while (rs.next()){
                if(rs.getString("id").equals(upid.getText())){

                    prs.setString(1, upfname.getText());
                    prs.setString(2, uplname.getText());
                    prs.setString(3, upsex.getText());
                    prs.setString(4, updept.getText());
                    prs.setInt(5, Integer.parseInt(upbatch.getText()));
                    prs.setString(6, upid.getText());
                    prs.executeUpdate();
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "YOU HAVE SUCCESSFULY ADD A UPDATE");
                    a.show();
                }
            }


        }

    }

}
