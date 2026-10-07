package com.college.erp.model;

public class Course {

    private int id;
    private String courseCode;
    private String courseName;
    private String department;
    private String duration;
    private int credits;
    private String description;

    public Course() {
    }

    public Course(int id,
                  String courseCode,
                  String courseName,
                  String department,
                  String duration,
                  int credits,
                  String description) {

        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.duration = duration;
        this.credits = credits;
        this.description = description;
    }

    public Course(String courseCode,
                  String courseName,
                  String department,
                  String duration,
                  int credits,
                  String description) {

        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.duration = duration;
        this.credits = credits;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}