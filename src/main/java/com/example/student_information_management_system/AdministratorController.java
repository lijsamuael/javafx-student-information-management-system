package com.example.student_information_management_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdministratorController implements Initializable {

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
    private TableColumn<Stud_list,Integer> batchcol;
    @FXML
    private TableColumn<Stud_list, String> colId;

    @FXML
    private TableColumn<Stud_list, String> depcol;

    @FXML
    private TableColumn<Stud_list, String> fnamecol;
    @FXML
    private TableView<Stud_list> list_table;

    @FXML
    private TableColumn<Stud_list, String> lnamecol;

    @FXML
    private TableColumn<Stud_list, String> sexcol;

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
    private Label searchbatch;

    @FXML
    private Label searchdep;

    @FXML
    private Label searchf;

    @FXML
    private Label searchid;

    @FXML
    private Label searchl;

    @FXML
    private Label laberror;

    @FXML
    private Label searchsex;


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
    void addStudent(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(txtaid.equals("") || txtafname.equals("") || txtalname.equals("") || txtasex.equals("") || txtadept.equals("") || txtabatch.equals("") ){
            Alert a = new Alert(Alert.AlertType.WARNING, "One or more empty fileds are empty");
        }
        else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
            String query = "INSERT INTO `account`  VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prs = con.prepareStatement(query);
            prs.setString(1, txtaid.getText());
            prs.setString(2, txtafname.getText());
            prs.setString(3, txtalname.getText());
            prs.setString(4, txtasex.getText());
            prs.setString(5, txtadept.getText());
            prs.setInt(6, Integer.parseInt(txtabatch.getText()));
            prs.executeUpdate();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "YOU HAVE SUCCESSFULY ADD A STUDENT");
            a.show();
        }
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
    void deleteStudent(ActionEvent event) throws ClassNotFoundException, SQLException {
        // DELETE FROM `account` WHERE id = 1
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
        String query = "DELETE FROM account WHERE id = ?";
        PreparedStatement prs = con.prepareStatement(query);
        prs.setString(1,txtdsearch.getText());
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "ARE YOU SURE TO DELETE");
        a.show();
        prs.executeUpdate();
        Alert aa = new Alert(Alert.AlertType.INFORMATION, "You have successfuly delet the student");
        a.show();




    }


    @FXML
    void searchStudent(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        if(event.getSource() == btnssearch)
        {
            if (txtssearch.getText() == "") {

                laberror.setText("The search field is empty. Please enter something");
            }
            else
            {
                laberror.setText(" ");
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from account");
                while(rs.next()) {
                    if( txtssearch.getText().equals(rs.getString("fname")))
                    {
                        laberror.setText("the name is found ");
                        searchid.setText(rs.getString("id"));
                        searchf.setText(rs.getString("fname"));
                        searchl.setText(rs.getString("lname"));
                        searchsex.setText(rs.getString("sex"));
                        searchdep.setText(rs.getString("department"));
                        searchbatch.setText(rs.getString("batch"));
                    }
                    else
                    {
                        laberror.setText("the name doesn't found ");
                    }

                }
            }
        }
    }


    @FXML
    void updateStudent(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(txtusearch.equals("") || txtufname.equals("") || txtulname.equals("") || txtusex.equals("") || txtudept.equals("") || txtubatch.equals("") ){
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
                if(rs.getString("id").equals(txtusearch.getText())){

                    prs.setString(1, txtufname.getText());
                    prs.setString(2, txtulname.getText());
                    prs.setString(3, txtusex.getText());
                    prs.setString(4, txtudept.getText());
                    prs.setInt(5, Integer.parseInt(txtubatch.getText()));
                    prs.setString(6, txtusearch.getText());
                    prs.executeUpdate();
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "YOU HAVE SUCCESSFULY ADD A UPDATE");
                    a.show();
                }
            }


        }

    }
    ObservableList<Stud_list> list3= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");

            ResultSet sl = con.createStatement().executeQuery("select * from account");

            while (sl.next()) {
                list3.add(
                        new Stud_list(sl.getString("id"),
                                sl.getString("fname"),
                                sl.getString("lname"),
                                sl.getString("sex"),
                                sl.getString("department"),
                                sl.getInt("batch")));
            }
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        colId.setCellValueFactory(new PropertyValueFactory<Stud_list, String>("id"));
        fnamecol.setCellValueFactory(new PropertyValueFactory<Stud_list, String>("f_name"));
        lnamecol.setCellValueFactory(new PropertyValueFactory<Stud_list, String>("l_name"));
        sexcol.setCellValueFactory(new PropertyValueFactory<Stud_list, String>("sex"));
        depcol.setCellValueFactory(new PropertyValueFactory<Stud_list, String>("departement"));
        batchcol.setCellValueFactory(new PropertyValueFactory<Stud_list, Integer>("batch"));
        list_table.setItems(list3);

    }
}
