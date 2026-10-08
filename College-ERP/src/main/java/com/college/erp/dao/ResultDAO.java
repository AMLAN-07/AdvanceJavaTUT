package com.college.erp.dao;

import com.college.erp.model.Result;
import com.college.erp.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO {

    public boolean addResult(Result result) {

        String sql = """
                INSERT INTO results
                (student_id, course_id, marks, grade, semester, remarks)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, result.getStudentId());
            statement.setInt(2, result.getCourseId());
            statement.setDouble(3, result.getMarks());
            statement.setString(4, result.getGrade());
            statement.setInt(5, result.getSemester());
            statement.setString(6, result.getRemarks());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public List<Result> getAllResults() {

        List<Result> resultList = new ArrayList<>();

        String sql = """
                SELECT id, student_id, course_id, marks, grade, semester, remarks
                FROM results
                ORDER BY id DESC
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Result result = new Result(
                        resultSet.getInt("id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("course_id"),
                        resultSet.getDouble("marks"),
                        resultSet.getString("grade"),
                        resultSet.getInt("semester"),
                        resultSet.getString("remarks")
                );

                resultList.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return resultList;
    }

    public Result getResultById(int id) {

        String sql = """
                SELECT id, student_id, course_id, marks, grade, semester, remarks
                FROM results
                WHERE id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    return new Result(
                            resultSet.getInt("id"),
                            resultSet.getInt("student_id"),
                            resultSet.getInt("course_id"),
                            resultSet.getDouble("marks"),
                            resultSet.getString("grade"),
                            resultSet.getInt("semester"),
                            resultSet.getString("remarks")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateResult(Result result) {

        String sql = """
                UPDATE results
                SET student_id = ?,
                    course_id = ?,
                    marks = ?,
                    grade = ?,
                    semester = ?,
                    remarks = ?
                WHERE id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, result.getStudentId());
            statement.setInt(2, result.getCourseId());
            statement.setDouble(3, result.getMarks());
            statement.setString(4, result.getGrade());
            statement.setInt(5, result.getSemester());
            statement.setString(6, result.getRemarks());
            statement.setInt(7, result.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteResult(int id) {

        String sql = "DELETE FROM results WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }  catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}