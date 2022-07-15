package com.example.student_information_management_system;
import java.sql.*;
public class DatabaseConnection {

   public Connection con;
   public Statement st;
   public ResultSet rs;


   public DatabaseConnection() throws SQLException, ClassNotFoundException {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
   }
}









