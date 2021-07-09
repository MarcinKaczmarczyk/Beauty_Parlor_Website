<%--
  Created by IntelliJ IDEA.
  User: marcinkaczmarczyk
  Date: 06.07.2021
  Time: 13:50
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



                    <form:form action="/reservation/visitTime" method="Post" >
                <select  name="dateList" >
                    <c:forEach items="${dateList}" var="date">
                        <option name="date" value="${date}">${date}</option>
                    </c:forEach>
                </select>
                        <button>Wybierz<button>


                    </form:form>

            </div>
        </div>
    </div>
</section>


<%@include file="../JSP/javascript.jsp" %>
</body>
</html>