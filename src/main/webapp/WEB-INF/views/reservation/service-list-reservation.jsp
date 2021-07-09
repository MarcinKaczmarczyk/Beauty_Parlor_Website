<%--
  Created by IntelliJ IDEA.
  User: marcinkaczmarczyk
  Date: 30.06.2021
  Time: 17:07
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
                        <th scope="col" class="col-1">Lp</th>
                        <th scope="col" class="col-2">Nazwa</th>
                        <th scope="col" class="col-7">Opis</th>
                        <th scope="col" class="col-1">Cena</th>
                        <th scope="col" class="col-1 center"></th>
                    </tr>
                    </thead>
                    <tbody class="text-color-lighter">
                    <form:form action="/reservation/visit" method="post" modelAttribute="serviceList">
                    <c:forEach items="${serviceList}" var="service">

                        <tr class="d-flex">
                            <th scope="row" class="col-1">1</th>
                            <td class="col-2">
                                    ${service.name}
                            </td>
                            <td class="col-7">
                                    ${service.description}
                            </td>
                            <td class="col-1">
                                    ${service.price} zł
                            </td>
                            <td class="col-1 d-flex align-items-center justify-content-center flex-wrap">
<%--                                Niestety wysyła ciągle ten sam czas wydaje mi się że pierwszy pobrany --%>
<%--                                <input type="hidden" name="serviceTime" value="${service.executionTime}">--%>
                               <form:button  name="serviceName" value="${service.name}">Zapisz się</form:button>
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