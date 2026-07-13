package org.example;


import com.mysql.cj.jdbc.Driver;
import org.example.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.util.Scanner;


public class App
{
    public static void main( String[] args ){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "hzkk4567@A");
        PreparedStatement pr=con.prepareStatement("select * from student_data where st_id=?");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter student ID");
       int id= sc.nextInt();
        sc.nextLine();
        pr.setInt(1,id);
        ResultSet rs=pr.executeQuery();
        while(rs.next()){
            System.out.println("id:"+rs.getInt(1));
            System.out.println("name:"+rs.getString(2));
            System.out.println("domain:"+rs.getString(3));
        }


        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }


    }
}
