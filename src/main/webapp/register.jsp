<%--
  Created by IntelliJ IDEA.
  User: odtselmuun
  Date: 2022.10.11
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<% if(session.getAttribute("user")==null) {%>
<h1>Registration</h1>
<form action="RegisterServlet" method="POST">
    <input name="username" title="username" placeholder="username" required>
    <input name="password" type="password" title="password" placeholder="password" required>
    <input name="repeat_password" type="password" title="repeat_password" placeholder="repeat_password" required>
    <input type="submit">
</form>
<%} else {
    response.sendRedirect("dashboard.jsp");
}%>
</body>
</html>
