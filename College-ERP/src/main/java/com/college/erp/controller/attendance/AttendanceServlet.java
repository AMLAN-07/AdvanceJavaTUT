package com.college.erp.controller.attendance;

import com.college.erp.model.Attendance;
import com.college.erp.service.AttendanceService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {

    private AttendanceService attendanceService;

    @Override
    public void init() {
        attendanceService = new AttendanceService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            request.getRequestDispatcher(
                    "/WEB-INF/views/attendance/add.jsp"
            ).forward(request, response);

        } else if ("edit".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Attendance attendance =
                    attendanceService.getAttendanceById(id);

            request.setAttribute("attendance", attendance);

            request.getRequestDispatcher(
                    "/WEB-INF/views/attendance/edit.jsp"
            ).forward(request, response);

        } else if ("delete".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            attendanceService.deleteAttendance(id);

            response.sendRedirect(
                    request.getContextPath() + "/attendance"
            );

        } else {

            request.setAttribute(
                    "attendanceList",
                    attendanceService.getAllAttendance()
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/attendance/list.jsp"
            ).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            int studentId = Integer.parseInt(
                    request.getParameter("studentId")
            );

            LocalDate attendanceDate = LocalDate.parse(
                    request.getParameter("attendanceDate")
            );

            String status = request.getParameter("status");
            String remarks = request.getParameter("remarks");

            if ("update".equals(action)) {

                int id = Integer.parseInt(
                        request.getParameter("id")
                );

                Attendance attendance = new Attendance(
                        id,
                        studentId,
                        attendanceDate,
                        status,
                        remarks
                );

                attendanceService.updateAttendance(attendance);

            } else {

                Attendance attendance = new Attendance(
                        studentId,
                        attendanceDate,
                        status,
                        remarks
                );

                attendanceService.addAttendance(attendance);
            }

            response.sendRedirect(
                    request.getContextPath() + "/attendance"
            );

        } catch (Exception e) {

            e.printStackTrace();

            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid attendance data"
            );
        }
    }
}