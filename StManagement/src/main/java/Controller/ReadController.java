package Controller;

import Service.StudentService;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/read")
public class ReadController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        StudentService sts = new StudentService();

        Student student = sts.get(id);

        if (student != null) {
            req.setAttribute("student", student);
            req.getRequestDispatcher("student.jsp").forward(req, resp);
        } else {
            resp.getWriter().println("Student not found!");
        }
    }
}
