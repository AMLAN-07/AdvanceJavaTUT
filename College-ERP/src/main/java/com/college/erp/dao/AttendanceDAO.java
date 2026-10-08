package com.college.erp.dao;

import com.college.erp.model.Attendance;
import com.college.erp.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public boolean addAttendance(Attendance attendance) {

        String sql = """
                INSERT INTO attendance
                (student_id, attendance_date, status, remarks)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, attendance.getStudentId());
            statement.setDate(2, Date.valueOf(attendance.getAttendanceDate()));
            statement.setString(3, attendance.getStatus());
            statement.setString(4, attendance.getRemarks());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public List<Attendance> getAllAttendance() {

        List<Attendance> attendanceList = new ArrayList<>();

        String sql = """
                SELECT id, student_id, attendance_date, status, remarks
                FROM attendance
                ORDER BY attendance_date DESC, id DESC
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Attendance attendance = new Attendance(
                        resultSet.getInt("id"),
                        resultSet.getInt("student_id"),
                        resultSet.getDate("attendance_date").toLocalDate(),
                        resultSet.getString("status"),
                        resultSet.getString("remarks")
                );

                attendanceList.add(attendance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return attendanceList;
    }

    public Attendance getAttendanceById(int id) {

        String sql = """
                SELECT id, student_id, attendance_date, status, remarks
                FROM attendance
                WHERE id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    return new Attendance(
                            resultSet.getInt("id"),
                            resultSet.getInt("student_id"),
                            resultSet.getDate("attendance_date").toLocalDate(),
                            resultSet.getString("status"),
                            resultSet.getString("remarks")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }  catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateAttendance(Attendance attendance) {

        String sql = """
                UPDATE attendance
                SET student_id = ?,
                    attendance_date = ?,
                    status = ?,
                    remarks = ?
                WHERE id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, attendance.getStudentId());
            statement.setDate(2, Date.valueOf(attendance.getAttendanceDate()));
            statement.setString(3, attendance.getStatus());
            statement.setString(4, attendance.getRemarks());
            statement.setInt(5, attendance.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }  catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteAttendance(int id) {

        String sql = "DELETE FROM attendance WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}