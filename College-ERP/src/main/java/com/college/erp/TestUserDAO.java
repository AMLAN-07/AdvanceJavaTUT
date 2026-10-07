package com.college.erp;

import com.college.erp.dao.UserDAO;
import com.college.erp.dao.impl.UserDAOImpl;
import com.college.erp.model.User;

public class TestUserDAO {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAOImpl();

        User user = userDAO.findByUsername("admin");

        if (user != null) {

            System.out.println("User found!");
            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Role: " + user.getRole());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Status: " + user.getStatus());

        } else {

            System.out.println("User not found!");
        }
    }
}