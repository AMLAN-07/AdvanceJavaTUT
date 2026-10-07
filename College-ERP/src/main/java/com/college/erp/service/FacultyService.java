package com.college.erp.service;

import com.college.erp.dao.FacultyDAO;
import com.college.erp.model.Faculty;

import java.util.List;

public class FacultyService {

    private final FacultyDAO facultyDAO;

    public FacultyService() {
        facultyDAO = new FacultyDAO();
    }

    public boolean addFaculty(Faculty faculty) {
        return facultyDAO.addFaculty(faculty);
    }

    public List<Faculty> getAllFaculties() {
        return facultyDAO.getAllFaculties();
    }

    public Faculty getFacultyById(int id) {
        return facultyDAO.getFacultyById(id);
    }

    public boolean updateFaculty(Faculty faculty) {
        return facultyDAO.updateFaculty(faculty);
    }

    public boolean deleteFaculty(int id) {
        return facultyDAO.deleteFaculty(id);
    }
}