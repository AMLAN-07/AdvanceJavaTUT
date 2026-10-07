package com.college.erp;

import com.college.erp.model.User;
import com.college.erp.service.AuthService;

public class TestAuth {

    public static void main(String[] args) {

        AuthService authService = new AuthService();

        User user = authService.authenticate(
                "admin",
                "admin123"
        );

        if (user != null) {

            System.out.println("Login successful!");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Role: " + user.getRole());

        } else {

            System.out.println("Invalid username or password!");
        }
    }
}