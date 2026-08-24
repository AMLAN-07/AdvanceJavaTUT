package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Service.StudentService;
import java.io.IOException;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id =Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        String name = req.getParameter("name");
        System.out.println(name);
        String email = req.getParameter("email");
        System.out.println(email);
        int redgno =Integer.parseInt(req.getParameter("redgno"));
        System.out.println(redgno);
        String password = req.getParameter("password");
        System.out.println(password);
        StudentService sts = new StudentService();
        if(sts.update(id,name,email,redgno,password)){
            resp.sendRedirect("login.html");
        }
    }
}
