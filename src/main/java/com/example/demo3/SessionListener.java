package com.example.demo3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


@WebListener
public class SessionListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    private ArrayList<UserBean> activeUsers;

    public SessionListener() throws IOException {
        super();
        this.activeUsers=new ArrayList<>();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session destroyed");
        /* Session is destroyed. */
        UserBean u = (UserBean) se.getSession().getAttribute("user");
        this.activeUsers.remove(u);
        ServletContext context = se.getSession().getServletContext();
        context.setAttribute("users", this.activeUsers);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("att added");
        if(Objects.equals(sbe.getName(), "user")) {
            UserBean u = (UserBean) sbe.getValue();
            this.activeUsers.add(u);
            ServletContext context = sbe.getSession().getServletContext();
            context.setAttribute("users", this.activeUsers);
        }
    }
}
