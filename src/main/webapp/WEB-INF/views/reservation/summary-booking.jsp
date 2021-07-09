<%--
  Created by IntelliJ IDEA.
  User: marcinkaczmarczyk
  Date: 07.07.2021
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>


<%@include file="../JSP/head.jsp" %>

<%@include file="../JSP/db-header.jsp" %>


<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@include file="../JSP/db-list.jsp" %>


        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">


                <form action="/reservation/confirmation" method="post">
                    <div class="m-4 p-4 border-dashed">
                        <h2 class="dashboard-content-title">
                            <span>Twoja Wizyta</span>
                        </h2>
                        <table class="table">
                            <thead>
                            <tr class="d-flex">
                                <th class="col-2">Sprawdź dane i potwierdź wizytę</th>
                                <th class="col-8"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="d-flex">
                                <td class="col-2">Imię pracownika:</td>
                                <td class="col-8">${bookingVisit.employeeName}</td>
                            </tr>
                            <tr class="d-flex">
                                <td class="col-2">Nazwa usługi:</td>
                                <td class="col-8">${bookingVisit.serviceName}</td>
                            </tr>
                            <tr class="d-flex">
                                <td class="col-2">Dnia:</td>
                                <td class="col-8">${bookingVisit.visitDay}</td>
                            </tr>
                            <tr class="d-flex">
                                <td class="col-2">Na godzinę:</td>
                                <td class="col-8">${bookingVisit.visitHours}</td>
                            </tr>
                            <tr class="d-flex">
                                <td class="col-2">Do zapłaty:</td>
                                <td class="col-8">${bookingVisit.price}zł</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <button name="bool" value="true" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Potwierdzam</button>
                    <button name="bool" value="false" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Chcę wybrać inny termin</button>
                </form>
            </div>
        </div>
    </div>
</section>


<%@include file="../JSP/javascript.jsp" %>
</body>
</html>