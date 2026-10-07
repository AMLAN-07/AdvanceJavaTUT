package com.college.erp.dao;

import com.college.erp.model.Course;
import com.college.erp.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public boolean addCourse(Course course) {

        String sql = "INSERT INTO courses " +
                "(course_code, course_name, department, duration, credits, description) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, course.getCourseCode());
            statement.setString(2, course.getCourseName());
            statement.setString(3, course.getDepartment());
            statement.setString(4, course.getDuration());
            statement.setInt(5, course.getCredits());
            statement.setString(6, course.getDescription());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
        return false;
        }
    }

    public List<Course> getAllCourses() {

        List<Course> courses = new ArrayList<>();

        String sql = "SELECT * FROM courses ORDER BY id";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Course course = new Course(
                        resultSet.getInt("id"),
                        resultSet.getString("course_code"),
                        resultSet.getString("course_name"),
                        resultSet.getString("department"),
                        resultSet.getString("duration"),
                        resultSet.getInt("credits"),
                        resultSet.getString("description")
                );

                courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return courses;
    }

    public Course getCourseById(int id) {

        String sql = "SELECT * FROM courses WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    return new Course(
                            resultSet.getInt("id"),
                            resultSet.getString("course_code"),
                            resultSet.getString("course_name"),
                            resultSet.getString("department"),
                            resultSet.getString("duration"),
                            resultSet.getInt("credits"),
                            resultSet.getString("description")
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

    public boolean updateCourse(Course course) {

        String sql = "UPDATE courses SET " +
                "course_code = ?, course_name = ?, department = ?, " +
                "duration = ?, credits = ?, description = ? " +
                "WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, course.getCourseCode());
            statement.setString(2, course.getCourseName());
            statement.setString(3, course.getDepartment());
            statement.setString(4, course.getDuration());
            statement.setInt(5, course.getCredits());
            statement.setString(6, course.getDescription());
            statement.setInt(7, course.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCourse(int id) {

        String sql = "DELETE FROM courses WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}