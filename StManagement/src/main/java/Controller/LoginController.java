package Controller;

import Service.StudentService;
import entity.Student;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        email=email.toLowerCase();
        StudentService service=new StudentService();

        Student st=service.validate(email,password);
        if(st!=null){
            Cookie cookie=new Cookie("email",email);
            response.addCookie(cookie);
            cookie.setMaxAge(60*60);

            System.out.println(st);
            response.sendRedirect("home.html");
        }else {
            response.sendRedirect("login.html");
        }




    }
}
