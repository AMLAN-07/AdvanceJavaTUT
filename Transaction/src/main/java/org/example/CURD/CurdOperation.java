package org.example.CURD;

import org.example.DBconnection.DbConnection;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CurdOperation {
    public void createUser(User user){
        String sql="insert into account(account_no, name, balance) values(?,?,?)";
        try {
            Connection con= DbConnection.getConnection();
            PreparedStatement prs=con.prepareStatement(sql);
            prs.setInt(1,user.getAccountNo());
            prs.setString(2,user.getName());
            prs.setDouble(3,user.getBalance());
            prs.executeUpdate();
            System.out.println("User created successfully");
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    public void getAllUsers(){
        String sql="select * from account";
        try {
            Connection con=DbConnection.getConnection();
            PreparedStatement prs=con.prepareStatement(sql);
            ResultSet rs=prs.executeQuery();
            while(rs.next()){
                System.out.println("Account no: "+rs.getInt(1)+" Name: "+rs.getString(2)+" Balance: "+rs.getDouble(3));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void searchUser(int accountNo){
        String sql="Select * from account where account_no=?";
        try {
            Connection con=DbConnection.getConnection();
            PreparedStatement prs=con.prepareStatement(sql);
            prs.setInt(1,accountNo);
            ResultSet rs=prs.executeQuery();
            if(rs.next()){
                System.out.println("Account no: "+rs.getInt(1)+" Name: "+rs.getString(2)+" Balance: "+rs.getDouble(3));
            }else {
                System.out.println("Account not found");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateUser(User user){
        String sql="update account set name=?,balance=? where account_no=?";
        try {
            Connection con=DbConnection.getConnection();
            PreparedStatement prs=con.prepareStatement(sql);
            prs.setString(1,user.getName());
            prs.setDouble(2,user.getBalance());
            prs.setInt(3,user.getAccountNo());
            prs.executeUpdate();
//            if(rs){
                System.out.println("User updated successfully");
//            }else{
//                System.out.println("Server issue due to Wether");
//            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    };

    public void deleteUser(int userNo){
        String sql="delete from account where account_no=?";
        try {
            Connection con=DbConnection.getConnection();
            PreparedStatement prs=con.prepareStatement(sql);
            prs.setInt(1,userNo);
            prs.executeUpdate();
            System.out.println("User deleted successfully");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
