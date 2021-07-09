<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 22/04/2021
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-between">
        <a href="/" class="navbar-brand main-logo main-logo-smaller">
            Studio <span>Od</span> Nowa
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="../services">Zabiegi</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href="/about">O Nas</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="/contact">Kontakt</a>
            </li>
        </ul>
        <div class="d-flex justify-content-around">
            <h4 class="text-light mr-3">Imię ${User.Name}</h4>
            <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>
        </div>
    </nav>
</header>
</body>
</html>
