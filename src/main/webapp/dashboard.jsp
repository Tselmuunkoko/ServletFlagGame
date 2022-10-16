<%--
  Created by IntelliJ IDEA.
  User: odtselmuun
  Date: 2022.10.13
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Play</title>
</head>
<body>
<jsp:include page="header.jsp" />
<jsp:useBean id="user"
class="com.example.demo3.UserBean"
scope="session"/>
<div>Score: <jsp:getProperty name="user" property="score" /></div>
<a href="GameServlet">Play</a>
</body>
</html>
