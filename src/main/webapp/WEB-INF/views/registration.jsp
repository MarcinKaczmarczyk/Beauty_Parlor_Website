<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>


<%@include file="JSP/header.jsp"%>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <!-- fix action, method -->
                <!-- add name attribute for all inputs -->
                <form:form method="post" modelAttribute="user" class="padding-small text-center">
                    <h1 class="text-color-darker">Rejestracja</h1>
                    <form:errors path="userName"/>
                    <div class="form-group">
                        <form:input class="form-control" path="userName" placeholder="Login"/>
                    </div>
                    <form:errors path="password"/>
                    <div class="form-group">
                        <form:password class="form-control" path="password" placeholder="hasło"/>
                    </div>
                    <form:errors path="password"/>
                    <div class="form-group">
                        <form:password class="form-control" path="rePassword" placeholder="powtórz hasło"/>
                    </div>
                    <form:errors path="name"/>
                    <div class="form-group">
                        <form:input class="form-control" path="name" placeholder="imię"/>
                    </div>
                    <form:errors path="surname"/>
                    <div class="form-group">
                        <form:input class="form-control" path="surname" placeholder="nazwisko"/>
                    </div>
                    <form:errors path="phoneNumber"/>
                    <div class="form-group">
                        <form:input class="form-control" path="phoneNumber" placeholder="numer telefonu"/>
                    </div>
                    <form:errors path="dateOfBirth"/>
                    <div class="form-group">
                        <form:input type="date" class="form-control" path="strDateOfBirth" placeholder="Data Urodzin dd/MM/yyyy"/>
                    </div>
                    <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>
                </form:form>
            </div>
        </div>
    </div>
</section>


<%@include file="JSP/javascript.jsp"%>
</body>
</html>