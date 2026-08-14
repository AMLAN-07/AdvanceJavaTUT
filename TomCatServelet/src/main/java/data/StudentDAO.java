package data;

import data.DbConnection;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class StudentDAO {

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, age, email, course) VALUES (?, ?, ?, ?)";
        try {
            Connection con= DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCourse());

            ResultSet rs=ps.executeQuery();
            System.out.println("Student Added Successfully");

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}