<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Update password</title>
</head>

<body>
    <div class="main">
        <div class="box">
        <img src="<c:url value='/resources/img/logout.jpg'/>" width="50px"/>
            <h4>${nombreEstudianteCS}</h4>
            <p>
                ESTAS SEGURO DE CERRAR ESTE CICLO?
            </p>
        </div>

    </div>
    <div>
        <a href="${pageContext.request.contextPath}/closeSemesterSuccess">
            <div class="btn2">Cerrar ciclo</div>
        </a> <!-- End Btn -->
    </div>

</body>

</html>