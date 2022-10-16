package com.example.demo3.servlets;

import com.example.demo3.UserBean;
import com.example.demo3.UserSerializer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "authServlet", value="/auth-servlet")
public class AuthServlet extends HttpServlet {
    public static boolean isAdmin(String name, String password ) {
        return name.equals("admin")&&password.equals("habusabu");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        UserSerializer serializer = new UserSerializer("user.txt");
        UserBean u = serializer.getUserList().stream().filter(userBean ->
                Objects.equals(userBean.getUsername(), name) && Objects.equals(userBean.getPassword(), password)
        ).findFirst().orElse(null);
        System.out.println(serializer.getUserList());
        HttpSession session = request.getSession();
        if(u!=null) {
            System.out.println(u.toString());
            synchronized(session) {
                session.setAttribute("user", u);
            }
            response.sendRedirect("dashboard.jsp");
        }
        else {
            UserBean admin = new UserBean("admin","habusabu");
            if(isAdmin(name,password)) {
                synchronized(session) {
                    session.setAttribute("user", admin);
                }
                response.sendRedirect("admin.jsp");
            }
            else response.sendRedirect("index.jsp");
        }
    }
}
