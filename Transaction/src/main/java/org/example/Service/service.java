package org.example.Service;

import org.example.DBconnection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class service {

    public void deposit(int accountNo, double amount){
        String sql = "UPDATE account SET balance = balance + ? WHERE account_no = ?";
        try {
            Connection con= DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, accountNo);
            ps.setDouble(2, amount);
            ResultSet rs=ps.executeQuery();
            double balance = rs.getDouble("balance");
            System.out.println("deposit success balance:"+ balance);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void withdraw(int accountNo, double amount) {

        try {
            Connection con = DbConnection.getConnection();
            String sql = "SELECT balance FROM account WHERE account_no = ?";
            PreparedStatement ps1 = con.prepareStatement(sql);
            ps1.setInt(1, accountNo);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                double balance = rs.getDouble("balance");

                if (balance >= amount) {

                    String sql2 = "UPDATE account SET balance = balance - ? WHERE account_no = ?";
                    PreparedStatement ps2 = con.prepareStatement(sql2);
                    ps2.setDouble(1, amount);
                    ps2.setInt(2, accountNo);
                    ps2.executeUpdate();
                    System.out.println("withdraw success total balance:"+(balance-amount) );

                } else {
                    System.out.println("Insufficient Balance.");
                }

            } else {
                System.out.println("Account Not Found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    transferMoney(int sender, int receiver, double amount);
}
