package com.college.erp.dao;

import com.college.erp.model.Faculty;
import com.college.erp.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAO {

    public boolean addFaculty(Faculty faculty) {

        String sql = "INSERT INTO faculties " +
                "(name, email, department, designation, phone, address) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, faculty.getName());
            statement.setString(2, faculty.getEmail());
            statement.setString(3, faculty.getDepartment());
            statement.setString(4, faculty.getDesignation());
            statement.setString(5, faculty.getPhone());
            statement.setString(6, faculty.getAddress());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Faculty> getAllFaculties() {

        List<Faculty> faculties = new ArrayList<>();

        String sql = "SELECT * FROM faculties ORDER BY id";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Faculty faculty = new Faculty(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("department"),
                        resultSet.getString("designation"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")
                );

                faculties.add(faculty);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return faculties;
    }

    public Faculty getFacultyById(int id) {

        String sql = "SELECT * FROM faculties WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    return new Faculty(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("department"),
                            resultSet.getString("designation"),
                            resultSet.getString("phone"),
                            resultSet.getString("address")
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

    public boolean updateFaculty(Faculty faculty) {

        String sql = "UPDATE faculties SET " +
                "name = ?, email = ?, department = ?, " +
                "designation = ?, phone = ?, address = ? " +
                "WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, faculty.getName());
            statement.setString(2, faculty.getEmail());
            statement.setString(3, faculty.getDepartment());
            statement.setString(4, faculty.getDesignation());
            statement.setString(5, faculty.getPhone());
            statement.setString(6, faculty.getAddress());
            statement.setInt(7, faculty.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFaculty(int id) {

        String sql = "DELETE FROM faculties WHERE id = ?";

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
            return false;
        }
    }
}