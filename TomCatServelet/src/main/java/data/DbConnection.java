package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection getConnection(){
        try {
            String url="jdbc:mysql://localhost:3306/studentdb";
            String user="root";
            String password="hzkk4567@A";
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}