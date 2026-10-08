package com.college.erp.model;

public class Result {

    private int id;
    private int studentId;
    private int courseId;
    private double marks;
    private String grade;
    private int semester;
    private String remarks;

    public Result() {
    }

    public Result(int studentId,
                  int courseId,
                  double marks,
                  String grade,
                  int semester,
                  String remarks) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.marks = marks;
        this.grade = grade;
        this.semester = semester;
        this.remarks = remarks;
    }

    public Result(int id,
                  int studentId,
                  int courseId,
                  double marks,
                  String grade,
                  int semester,
                  String remarks) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.marks = marks;
        this.grade = grade;
        this.semester = semester;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}