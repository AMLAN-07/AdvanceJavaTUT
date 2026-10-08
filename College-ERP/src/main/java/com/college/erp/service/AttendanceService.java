package com.college.erp.service;

import com.college.erp.dao.AttendanceDAO;
import com.college.erp.model.Attendance;

import java.util.List;

public class AttendanceService {

    private final AttendanceDAO attendanceDAO;

    public AttendanceService() {
        this.attendanceDAO = new AttendanceDAO();
    }

    public boolean addAttendance(Attendance attendance) {
        return attendanceDAO.addAttendance(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceDAO.getAllAttendance();
    }

    public Attendance getAttendanceById(int id) {
        return attendanceDAO.getAttendanceById(id);
    }

    public boolean updateAttendance(Attendance attendance) {
        return attendanceDAO.updateAttendance(attendance);
    }

    public boolean deleteAttendance(int id) {
        return attendanceDAO.deleteAttendance(id);
    }
}