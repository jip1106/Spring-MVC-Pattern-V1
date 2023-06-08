package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet" , urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        System.out.println("HelloServlet.service");
        
        String userName = request.getParameter("username");
        System.out.println("userName = " + userName);

        response.setContentType("text/plan");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + userName);

    }
}
