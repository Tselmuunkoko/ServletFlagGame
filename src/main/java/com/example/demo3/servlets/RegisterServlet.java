package com.example.demo3.servlets;

import com.example.demo3.UserBean;
import com.example.demo3.UserSerializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "registerServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repeatPassword = request.getParameter("repeat_password");
            if (password.equals(repeatPassword)) {
                if (AuthServlet.isAdmin(username, password)) {
                    request.setAttribute("message", "The user exists");
                }
                UserSerializer serializer = new UserSerializer("user.txt");
                UserBean userBean = new UserBean(username, password);
                if (serializer.getUserList().stream().noneMatch(u -> u.getUsername().equals(username))) {
                    serializer.writeToFile(userBean);
                    response.sendRedirect("index.jsp");
                    return;
                }
                else {
                    request.setAttribute("message", "The user exists");
                }
            } else {
                request.setAttribute("message", "The passwords didn't match.");
            }
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(401, "error");
        }
    }
}
