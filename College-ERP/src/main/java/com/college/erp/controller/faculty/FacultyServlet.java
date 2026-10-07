package com.college.erp.controller.faculty;

import com.college.erp.model.Faculty;
import com.college.erp.service.FacultyService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/faculty")
public class FacultyServlet extends HttpServlet {

    private FacultyService facultyService;

    @Override
    public void init() {
        facultyService = new FacultyService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            request.getRequestDispatcher(
                    "/WEB-INF/views/faculty/add.jsp"
            ).forward(request, response);

        } else if ("delete".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            facultyService.deleteFaculty(id);

            response.sendRedirect(
                    request.getContextPath() + "/faculty"
            );

        } else if ("edit".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Faculty faculty =
                    facultyService.getFacultyById(id);

            request.setAttribute(
                    "faculty",
                    faculty
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/faculty/edit.jsp"
            ).forward(request, response);

        } else {

            List<Faculty> faculties =
                    facultyService.getAllFaculties();

            request.setAttribute(
                    "faculties",
                    faculties
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/faculty/list.jsp"
            ).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("update".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String department =
                    request.getParameter("department");
            String designation =
                    request.getParameter("designation");
            String phone = request.getParameter("phone");
            String address =
                    request.getParameter("address");

            Faculty faculty = new Faculty(
                    id,
                    name,
                    email,
                    department,
                    designation,
                    phone,
                    address
            );

            boolean success =
                    facultyService.updateFaculty(faculty);

            if (success) {

                response.sendRedirect(
                        request.getContextPath() + "/faculty"
                );

            } else {

                request.setAttribute(
                        "error",
                        "Unable to update faculty."
                );

                request.setAttribute(
                        "faculty",
                        faculty
                );

                request.getRequestDispatcher(
                        "/WEB-INF/views/faculty/edit.jsp"
                ).forward(request, response);
            }

        } else {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String department =
                    request.getParameter("department");
            String designation =
                    request.getParameter("designation");
            String phone = request.getParameter("phone");
            String address =
                    request.getParameter("address");

            Faculty faculty = new Faculty(
                    name,
                    email,
                    department,
                    designation,
                    phone,
                    address
            );

            boolean success =
                    facultyService.addFaculty(faculty);

            if (success) {

                response.sendRedirect(
                        request.getContextPath() + "/faculty"
                );

            } else {

                request.setAttribute(
                        "error",
                        "Unable to add faculty."
                );

                request.getRequestDispatcher(
                        "/WEB-INF/views/faculty/add.jsp"
                ).forward(request, response);
            }
        }
    }
}