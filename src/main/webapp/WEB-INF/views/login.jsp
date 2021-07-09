<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<%@include file="JSP/header.jsp"%>
    <section class="dashboard-section">
        <div class="container pt-4 pb-4">
            <div class="border-dashed view-height">
                <div class="container w-25">
                    <form class="padding-small text-center" action="/login" method="post">
                        <h1 class="text-color-darker">Logowanie</h1>
                        <div class="form-group">
                            <input type="text" class="form-control" id="username" name="username" placeholder="login">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="hasło">
                        </div>
                        <button class="btn btn-color rounded-0" type="submit">Zaloguj</button>
                    </form>
                 </div>
            </div>
        </div>
    </section>
    <%@include file="JSP/javascript.jsp"%>
</body>
</html>