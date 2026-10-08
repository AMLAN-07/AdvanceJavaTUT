package com.college.erp.controller.result;

import com.college.erp.model.Result;
import com.college.erp.service.ResultService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    private ResultService resultService;

    @Override
    public void init() {
        resultService = new ResultService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            request.getRequestDispatcher(
                    "/WEB-INF/views/result/add.jsp"
            ).forward(request, response);

        } else if ("edit".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Result result = resultService.getResultById(id);

            request.setAttribute("result", result);

            request.getRequestDispatcher(
                    "/WEB-INF/views/result/edit.jsp"
            ).forward(request, response);

        } else if ("delete".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            resultService.deleteResult(id);

            response.sendRedirect(
                    request.getContextPath() + "/result"
            );

        } else {

            request.setAttribute(
                    "resultList",
                    resultService.getAllResults()
            );

            request.getRequestDispatcher(
                    "/WEB-INF/views/result/list.jsp"
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

            int courseId = Integer.parseInt(
                    request.getParameter("courseId")
            );

            double marks = Double.parseDouble(
                    request.getParameter("marks")
            );

            String grade = request.getParameter("grade");

            int semester = Integer.parseInt(
                    request.getParameter("semester")
            );

            String remarks = request.getParameter("remarks");

            if ("update".equals(action)) {

                int id = Integer.parseInt(
                        request.getParameter("id")
                );

                Result result = new Result(
                        id,
                        studentId,
                        courseId,
                        marks,
                        grade,
                        semester,
                        remarks
                );

                resultService.updateResult(result);

            } else {

                Result result = new Result(
                        studentId,
                        courseId,
                        marks,
                        grade,
                        semester,
                        remarks
                );

                resultService.addResult(result);
            }

            response.sendRedirect(
                    request.getContextPath() + "/result"
            );

        } catch (Exception e) {

            e.printStackTrace();

            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid result data"
            );
        }
    }
}