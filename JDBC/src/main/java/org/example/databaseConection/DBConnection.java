package org.example.databaseConection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/studentdb";
            String user = "postgres";
            String password = "hzkk4567@A";

            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}