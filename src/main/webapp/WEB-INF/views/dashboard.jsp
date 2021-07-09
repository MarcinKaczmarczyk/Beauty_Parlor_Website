
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>

<%@include file="JSP/head.jsp"%>


<%@include file="JSP/db-header.jsp" %>


    <section class="dashboard-section">
        <div class="row dashboard-nowrap">
            <%@include file="JSP/db-list.jsp" %>

            <div class="m-4 p-4 width-medium">
                <div class="dashboard-header m-4">
                    <div class="dashboard-menu">
                        <div class="menu-item border-dashed">
                            <a href="/reservation/service">
                                <i class="far fa-plus-square icon-plus-square"></i>
                                <span class="title">Umów wizytę</span>
                            </a>
                        </div>
                    </div>

                    <div class="dashboard-alerts">
                        <div class="alert-item alert-info">
                            <i class="fas icon-circle fa-info-circle"></i>
                            <span class="font-weight-bold">wizyty u fryzjera: 1</span>
                        </div>
                        <div class="alert-item alert-light">
                            <i class="far icon-calendar fa-calendar-alt"></i>
                            <span class="font-weight-bold">wizyty u kosmetyczki: 1</span>
                        </div>
                    </div>
                </div>
                <div class="m-4 p-4 border-dashed">
                    <h2 class="dashboard-content-title">
                        <span>Twoje Wizyty</span>
                    </h2>
                    <table class="table">
                        <thead>
                            <tr class="d-flex">
                                <th class="col-2">Poniedziałek</th>
                                <th class="col-8"></th>
                                <th class="col-2"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="d-flex">
                                <td class="col-2">śniadanie</td>
                                <td class="col-8">płatki owsiane z jagodami i komosą ryżową</td>
                                <td class="col-2"><button type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                            </tr>
                            <tr class="d-flex">
                                <td class="col-2">śniadanie</td>
                                <td class="col-8">kanapka z pastą rybną</td>
                                <td class="col-2"><button type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                            </tr>
                            <tr class="d-flex">
                                <td class="col-2">obiad</td>
                                <td class="col-8">zupa pomidorowa</td>
                                <td class="col-2"><button type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>


    <%@include file="JSP/javascript.jsp"%>
</body>
</html>