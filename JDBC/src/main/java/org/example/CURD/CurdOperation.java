package org.example.CURD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.databaseConection.DBConnection;
import org.example.entity.Student;

public class CurdOperation {
    
    public void addStudent(Student student) {
        String sql = "insert into student_data(st_id,name,domain) values(?,?,?)";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, student.getId());
            pr.setString(2, student.getName());
            pr.setString(3, student.getdomain());
            pr.executeUpdate();
            System.out.println("Student Added Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getStudentById(int id) {
        String sql = "select * from student_data where st_id=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                System.out.println("id:" + rs.getInt(1) + "  name:" + rs.getString(2) + "  domain:" + rs.getString(3));
            } else {
                System.out.println("Student Not Found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllStudents() {
        String sql = "select * from student_data";
        try {
            Connection con = DBConnection.getConnection();
            Statement pr = con.createStatement();
            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id:" + rs.getInt(1) + "  name:" + rs.getString(2) + "  domain:" + rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudent(int id, String name, String domain) {
        String sql = "update student_data set name=?, domain=? where st_id=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, name);
            pr.setString(2, domain);
            pr.setInt(3, id);
            pr.executeUpdate();
            System.out.println("Student Updated Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStudent(int id) {
        String sql = "delete from student_data where st_id=?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, id);
            pr.executeUpdate();
            System.out.println("Student Deleted Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
