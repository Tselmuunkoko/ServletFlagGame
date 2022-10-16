package com.example.demo3.servlets;

import com.example.demo3.GameBean;
import com.example.demo3.UserBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GameServlet", value = "/GameServlet")
public class GameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameBean game = new GameBean();
        synchronized (session) {
            session.setAttribute("game", game);
        }
        response.sendRedirect("play.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Integer> answers = new ArrayList<>();
        try {
            answers.add(Integer.parseInt(request.getParameter("first")));
            answers.add(Integer.parseInt(request.getParameter("second")));
            answers.add(Integer.parseInt(request.getParameter("third")));
            HttpSession session = request.getSession();
            synchronized (session) {
                GameBean game = (GameBean) session.getAttribute("game");
                UserBean user = (UserBean) session.getAttribute("user");
                user.setScore(user.getScore() + game.match(answers));
                request.getSession().setAttribute("user", user);
            }
        } catch (NullPointerException ignored) {
        }
        response.sendRedirect("dashboard.jsp");
    }
}
