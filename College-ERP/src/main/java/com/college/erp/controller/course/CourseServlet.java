package com.college.erp.controller.course;

import com.college.erp.model.Course;
import com.college.erp.service.CourseService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {

    private CourseService courseService;

    @Override
    public void init() {
        courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            request.getRequestDispatcher(
                    "/WEB-INF/views/course/add.jsp"
            ).forward(request, response);

        } else if ("delete".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            courseService.deleteCourse(id);

            response.sendRedirect(
                    request.getContextPath() + "/course"
            );

        } else if ("edit".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Course course =
                    courseService.getCourseById(id);

            request.setAttribute(
                    "course",
                    course
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/course/edit.jsp"
            ).forward(request, response);

        } else {

            List<Course> courses =
                    courseService.getAllCourses();

            request.setAttribute(
                    "courses",
                    courses
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/course/list.jsp"
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

            String courseCode =
                    request.getParameter("courseCode");

            String courseName =
                    request.getParameter("courseName");

            String department =
                    request.getParameter("department");

            String duration =
                    request.getParameter("duration");

            int credits = Integer.parseInt(
                    request.getParameter("credits")
            );

            String description =
                    request.getParameter("description");

            Course course = new Course(
                    id,
                    courseCode,
                    courseName,
                    department,
                    duration,
                    credits,
                    description
            );

            boolean success =
                    courseService.updateCourse(course);

            if (success) {

                response.sendRedirect(
                        request.getContextPath() + "/course"
                );

            } else {

                request.setAttribute(
                        "error",
                        "Unable to update course."
                );

                request.setAttribute(
                        "course",
                        course
                );

                request.getRequestDispatcher(
                        "/WEB-INF/views/course/edit.jsp"
                ).forward(request, response);
            }

        } else {

            String courseCode =
                    request.getParameter("courseCode");

            String courseName =
                    request.getParameter("courseName");

            String department =
                    request.getParameter("department");

            String duration =
                    request.getParameter("duration");

            int credits = Integer.parseInt(
                    request.getParameter("credits")
            );

            String description =
                    request.getParameter("description");

            Course course = new Course(
                    courseCode,
                    courseName,
                    department,
                    duration,
                    credits,
                    description
            );

            boolean success =
                    courseService.addCourse(course);

            if (success) {

                response.sendRedirect(
                        request.getContextPath() + "/course"
                );

            } else {

                request.setAttribute(
                        "error",
                        "Unable to add course."
                );

                request.getRequestDispatcher(
                        "/WEB-INF/views/course/add.jsp"
                ).forward(request, response);
            }
        }
    }
}