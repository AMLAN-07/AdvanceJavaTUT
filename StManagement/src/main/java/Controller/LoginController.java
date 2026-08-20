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
//        Cookie ck[]=request.getCookies();
//        response.addCookie(ck[]);
//        Cookie ck=new Cookie(email,password);
//        response.addCookie(ck);
        Student st=service.validate(email,password);
        if(st!=null){
            System.out.println(st);
            response.sendRedirect("home.html");
        }




    }
}
