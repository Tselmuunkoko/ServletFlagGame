<%--
  Created by IntelliJ IDEA.
  User: odtselmuun
  Date: 2022.10.15
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<% if(session.getAttribute("user")==null) {%>
<h1>Authentication
</h1>
<form method="POST" action="auth-servlet">
    <input name="username" title="username" placeholder="username" required>
    <input name="password" title="password" type="password" placeholder="password" required>
    <input type="submit">
</form>
<a href="register.jsp">Click here to register</a>
<%} else {
    response.sendRedirect("dashboard.jsp");
}%>
</body>
</html>
