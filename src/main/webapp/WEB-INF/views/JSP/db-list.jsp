<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 21/04/2021
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul class="nav flex-column long-bg">
    <li class="nav-item">
        <a class="nav-link" href="/dashboard">
<%--        <a class="nav-link" href="/dashboard.jsp">--%>
            <span>Pulpit</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/recipes">
<%--        <a class="nav-link" href="/app-recipes.jsp">--%>
            <span>Twoje Konto</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/logout">
<%--        <a class="nav-link" href="/app-schedules.jsp">--%>
            <span>Wyloguj się</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
</ul>
</body>
</html>
