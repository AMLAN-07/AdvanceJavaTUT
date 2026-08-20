package Service;

import dao.DBConnection;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService {

    public boolean register(int id,String name,String email,String password){
        try {
            Connection con= DBConnection.getConnection();
            PreparedStatement pr= con.prepareStatement("insert into students values (?,?,?,?)");
            pr.setInt(1,id);
            pr.setString(2,name);
            pr.setString(3,email);
            pr.setString(4,password);
            int rows=pr.executeUpdate();
            if (rows>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Student validate(String email,String password){
        String sql="select * from students where email=? and password=?";
        try {
            Student  student=new Student();
            Connection con= DBConnection.getConnection();
            PreparedStatement prt=con.prepareStatement(sql);
            prt.setString(1,email);
            prt.setString(2,password);
            ResultSet rs=prt.executeQuery();

            if(rs.next()){
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setRegdno(rs.getInt(4));
                student.setPassword(rs.getString(5));
                return student;

            }else {
                return null;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }
}
