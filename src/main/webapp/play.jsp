<%--
  Created by IntelliJ IDEA.
  User: odtselmuun
  Date: 2022.10.13
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.example.demo3.GameBean" %>
<%@ page import="com.example.demo3.UserBean" %>
<html>
<head>
    <title>Play</title>
</head>
<body>
<jsp:include page="header.jsp" />
<jsp:useBean id="game" scope="session" class="com.example.demo3.GameBean"/>
<%
    int index = 0;
    for(String s:game.getCountryNameList()) {
    index++;
%>
<div>
    <%= index+ "."+s%>
</div>
<%}%>
<form method="post" action="GameServlet">
    <div width="100px;">
        <img src="flags/<%=game.getFlags().get(0)%>.jpg" alt="flag1">
        <input type="number" name="first" title="first" required placeholder="first answer">
    </div>
    <div width="100px;">
        <img src="flags/<%=game.getFlags().get(1)%>.jpg"  alt="flag2">
        <input type="number" name="second" title="second" required placeholder="second answer">
    </div>
    <div width="100px;">
    <img src="flags/<%=game.getFlags().get(2)%>.jpg"  alt="flag3">
    <input type="number" name="third" title="third" required placeholder="third answer">
    </div>
    <input type="submit">
</form>
</body>
</html>
