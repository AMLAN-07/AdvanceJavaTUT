package com.college.erp.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {
        "/admin/*",
        "/faculty",
        "/faculty/*",
        "/student",
        "/student/*",
        "/course",
        "/course/*",
        "/attendance",
        "/attendance/*",
        "/result",
        "/result/*"
})
public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        HttpSession session =
                httpRequest.getSession(false);

        if (session == null ||
                session.getAttribute("userId") == null) {

            httpResponse.sendRedirect(
                    httpRequest.getContextPath() + "/login"
            );

            return;
        }

        String role =
                (String) session.getAttribute("role");

        String uri = httpRequest.getRequestURI();

        if (uri.contains("/admin/") &&
                !"ADMIN".equals(role)) {

            httpResponse.sendError(
                    HttpServletResponse.SC_FORBIDDEN,
                    "Access Denied"
            );

            return;
        }

        if (uri.equals(httpRequest.getContextPath() + "/faculty")
                || uri.startsWith(httpRequest.getContextPath() + "/faculty/")) {

            if (!"ADMIN".equals(role)) {
                httpResponse.sendError(
                        HttpServletResponse.SC_FORBIDDEN,
                        "Access Denied"
                );
                return;
            }
        }

        if (uri.equals(httpRequest.getContextPath() + "/student")
                || uri.startsWith(httpRequest.getContextPath() + "/student/")) {

            if (!"ADMIN".equals(role)) {
                httpResponse.sendError(
                        HttpServletResponse.SC_FORBIDDEN,
                        "Access Denied"
                );
                return;
            }
        }

        if (uri.equals(httpRequest.getContextPath() + "/course")
                || uri.startsWith(httpRequest.getContextPath() + "/course/")) {

            if (!"ADMIN".equals(role)) {
                httpResponse.sendError(
                        HttpServletResponse.SC_FORBIDDEN,
                        "Access Denied"
                );
                return;
            }
        }

        if (uri.equals(httpRequest.getContextPath() + "/attendance")
                || uri.startsWith(httpRequest.getContextPath() + "/attendance/")) {

            if (!"ADMIN".equals(role)) {
                httpResponse.sendError(
                        HttpServletResponse.SC_FORBIDDEN,
                        "Access Denied"
                );
                return;
            }
        }

        if (uri.equals(httpRequest.getContextPath() + "/result")
                || uri.startsWith(httpRequest.getContextPath() + "/result/")) {

            if (!"ADMIN".equals(role)) {
                httpResponse.sendError(
                        HttpServletResponse.SC_FORBIDDEN,
                        "Access Denied"
                );
                return;
            }
        }

        chain.doFilter(request, response);
    }
}