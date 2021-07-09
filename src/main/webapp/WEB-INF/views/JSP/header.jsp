
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 13/04/2021
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<%@include file="head.jsp"%>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            Studio <span>Od</span> Nowa
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="/login">Zaloguj Się</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="/register">Zarejestruj Się</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="/services">Zabiegi</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href="/about">O Nas</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="/contact">Kontakt</a>
            </li>
        </ul>
    </nav>
</header>
</body>
</html>