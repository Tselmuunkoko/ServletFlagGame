package com.example.demo3;

import com.example.demo3.servlets.AuthServlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SessionFilter")
public class SessionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (session.getAttribute("user") == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        } else {
            UserBean userBean = (UserBean)(session.getAttribute("user"));
            if(AuthServlet.isAdmin(userBean.getUsername(),userBean.getPassword())) {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
                return;
            }
        }
        chain.doFilter(request,response);
    }
}
