<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<!DOCTYPE html>
<html lang="en">

<%@include file="../JSP/head.jsp" %>

<%@include file="../JSP/db-header.jsp" %>


<form action="" method="post">
    <section class="dashboard-section">
        <div class="row dashboard-nowrap">
            <div class="m-4 p-3 width-medium ">
                <div class="dashboard-content border-dashed p-3 m-4">
                    <div class="row border-bottom border-3 p-1 m-1">
                        <div class="col noPadding">
                            <h3 class="color-header text-uppercase">Wybierz rodzaj usługi</h3>
                        </div>
                        <div class="col d-flex justify-content-end mb-2 noPadding">

                        </div>

                    </div>
                    <div class="schedules-content">
                        <div class="schedules-content-header">
                            <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    <button type="submit" name="category" value="${cosmetic}" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Kosmetyka</button>
                                </span>
                            </div>
                            <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    <button type="submit" name="category" value="${hairdressing}" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Fryzjer</button>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</form>


<%@include file="../JSP/javascript.jsp"%>
</body>
</html>
