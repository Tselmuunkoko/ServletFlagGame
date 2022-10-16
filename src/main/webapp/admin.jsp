<%@ page import="com.example.demo3.UserBean" %>
<%@ page import="com.example.demo3.servlets.AuthServlet" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: odtselmuun
  Date: 2022.10.14
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <% UserBean admin = (UserBean)session.getAttribute("user");
        if(admin==null || !AuthServlet.isAdmin(admin.getUsername(),admin.getPassword()))  {
           response.sendError(401,"user cannot access");
        }
    %>
    <%
        ArrayList<UserBean> s = (ArrayList<UserBean>) request.getServletContext().getAttribute("users");
    %>
    <h2>Active users</h2>
    <table>
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Current Score</th>
        </tr>

    <% for (UserBean userBean :s) { %>
        <tr>
            <td><%=userBean.getUsername()%></td>
            <td><%=userBean.getPassword()%></td>
            <td><%=userBean.getScore()%></td>
        </tr>
    <% } %>
    </table>
</body>
</html>
