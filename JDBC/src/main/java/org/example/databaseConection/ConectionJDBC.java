package org.example.databaseConection;

import org.example.entity.Student;

import java.sql.*;

public class ConectionJDBC {
    public void  DbConnection(){
        String url="jdbc:mysql://localhost:3306/";
        String user="root";
        String password="hzkk4567@A";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            System.out.println("Connection Successful");

        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void addStudent(Student student){
        
    }
}
