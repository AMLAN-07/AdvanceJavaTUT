package com.college.erp.controller;

import com.college.erp.model.User;
import com.college.erp.service.AuthService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private AuthService authService;

    @Override
    public void init() {
        authService = new AuthService();
    }

    // GET /login
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/WEB-INF/views/auth/login.jsp"
        ).forward(request, response);
    }

    // POST /login
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(
                "Username received = [" + username + "]"
        );

        System.out.println(
                "Username length = " +
                        (username == null ? "null" : username.length())
        );

        System.out.println(
                "Password length = " +
                        (password == null ? "null" : password.length())
        );

        System.out.println("Username: " + username);
        System.out.println("Password received: " + (password != null));

        User user = authService.authenticate(
                username,
                password
        );

        System.out.println(
                "Authentication result: " +
                        (user != null ? "SUCCESS" : "FAILED")
        );

        if (user != null) {

            HttpSession session =
                    request.getSession(true);

            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());
            session.setAttribute("email", user.getEmail());

            session.setMaxInactiveInterval(30 * 60);

            response.sendRedirect(
                    request.getContextPath() + "/dashboard"
            );

        } else {

            request.setAttribute(
                    "error",
                    "Invalid username or password."
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/auth/login.jsp"
            ).forward(request, response);
        }
    }
}