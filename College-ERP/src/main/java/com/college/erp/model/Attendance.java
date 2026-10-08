package com.college.erp.model;

import java.time.LocalDate;

public class Attendance {

    private int id;
    private int studentId;
    private LocalDate attendanceDate;
    private String status;
    private String remarks;

    public Attendance() {
    }

    public Attendance(int studentId,
                      LocalDate attendanceDate,
                      String status,
                      String remarks) {
        this.studentId = studentId;
        this.attendanceDate = attendanceDate;
        this.status = status;
        this.remarks = remarks;
    }

    public Attendance(int id,
                      int studentId,
                      LocalDate attendanceDate,
                      String status,
                      String remarks) {
        this.id = id;
        this.studentId = studentId;
        this.attendanceDate = attendanceDate;
        this.status = status;
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

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}