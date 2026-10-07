package com.college.erp.controller.student;

import com.college.erp.model.Student;
import com.college.erp.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() {
        studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            request.getRequestDispatcher(
                    "/WEB-INF/views/student/add.jsp"
            ).forward(request, response);

        } else if ("delete".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            studentService.deleteStudent(id);

            response.sendRedirect(
                    request.getContextPath() + "/student"
            );

        } else if ("edit".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Student student =
                    studentService.getStudentById(id);

            request.setAttribute(
                    "student",
                    student
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/student/edit.jsp"
            ).forward(request, response);

        } else {

            List<Student> students =
                    studentService.getAllStudents();

            request.setAttribute("students", students);

            request.getRequestDispatcher(
                    "/WEB-INF/views/student/list.jsp"
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
            String course = request.getParameter("course");
            int age = Integer.parseInt(
                    request.getParameter("age")
            );
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            Student student = new Student(
                    id,
                    name,
                    email,
                    course,
                    age,
                    phone,
                    address
            );

            boolean success =
                    studentService.updateStudent(student);

            if (success) {

                response.sendRedirect(
                        request.getContextPath() + "/student"
                );

            } else {

                request.setAttribute(
                        "error",
                        "Unable to update student."
                );

                request.setAttribute(
                        "student",
                        student
                );

                request.getRequestDispatcher(
                        "/WEB-INF/views/student/edit.jsp"
                ).forward(request, response);
            }

        } else {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String course = request.getParameter("course");
            int age = Integer.parseInt(
                    request.getParameter("age")
            );
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            Student student = new Student(
                    name,
                    email,
                    course,
                    age,
                    phone,
                    address
            );

            boolean success =
                    studentService.addStudent(student);

            if (success) {

                response.sendRedirect(
                        request.getContextPath() + "/student"
                );

            } else {

                request.setAttribute(
                        "error",
                        "Unable to add student."
                );

                request.getRequestDispatcher(
                        "/WEB-INF/views/student/add.jsp"
                ).forward(request, response);
            }
        }
    }
}