package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import data.StudentDAO;
import entity.Student;

public class StudentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String course = request.getParameter("course");
        
        Student student = new Student(name.trim(), age, email.trim(), course);

        StudentDAO studentDao = new StudentDAO();
        studentDao.addStudent(student);
    }
}
