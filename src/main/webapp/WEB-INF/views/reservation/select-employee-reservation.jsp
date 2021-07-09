<%--
  Created by IntelliJ IDEA.
  User: marcinkaczmarczyk
  Date: 30.06.2021
  Time: 20:32
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


                <table class="table border-bottom schedules-content">
                    <thead>
                    <tr class="d-flex text-color-darker">
                        <th scope="col" class="col-2">Imię</th>
                        <th scope="col" class="col-2">Nazwisko</th>
<%--                        <th scope="col" class="col-2">Najbliższy termin</th>--%>
                        <th scope="col" class="col-1 center"></th>
                    </tr>
                    </thead>
                    <tbody class="text-color-lighter">
                    <form:form action="/reservation/visitDate" method="post" modelAttribute="employeeList">
                        <c:forEach items="${employeeList}" var="employee">

                            <tr class="d-flex">
                                <td class="col-2">
                                        ${employee.name}
                                </td>
                                <td class="col-2">
                                        ${employee.surname}
                                </td>
                                <td class="col-1 d-flex align-items-center justify-content-center flex-wrap">
                                    <form:button name="username" value="${employee.userName}">Zapisz się</form:button>
                                </td>
                            </tr>
                        </c:forEach>
                    </form:form>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>


<%@include file="../JSP/javascript.jsp" %>
</body>
</html>
