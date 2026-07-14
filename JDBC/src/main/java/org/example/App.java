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
        Statement pr=con.createStatement();
        String sql="select * from student";
        ResultSet rs=pr.executeQuery(sql);
        while(rs.next()){
            System.out.println("id:"+rs.getInt(1)+"  name:"+rs.getString(2)+"  domain:"+rs.getString(3));

        }
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }


    }
}
