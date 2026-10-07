package com.college.erp.service;

import com.college.erp.dao.CourseDAO;
import com.college.erp.model.Course;

import java.util.List;

public class CourseService {

    private final CourseDAO courseDAO;

    public CourseService() {
        courseDAO = new CourseDAO();
    }

    public boolean addCourse(Course course) {
        return courseDAO.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    public Course getCourseById(int id) {
        return courseDAO.getCourseById(id);
    }

    public boolean updateCourse(Course course) {
        return courseDAO.updateCourse(course);
    }

    public boolean deleteCourse(int id) {
        return courseDAO.deleteCourse(id);
    }
}