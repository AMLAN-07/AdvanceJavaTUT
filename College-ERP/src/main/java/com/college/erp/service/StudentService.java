package com.college.erp.service;

import com.college.erp.dao.StudentDAO;
import com.college.erp.model.Student;

import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    // CREATE
    public boolean addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    // READ ONE
    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    // UPDATE
    public boolean updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }

    // DELETE
    public boolean deleteStudent(int id) {
        return studentDAO.deleteStudent(id);
    }
}