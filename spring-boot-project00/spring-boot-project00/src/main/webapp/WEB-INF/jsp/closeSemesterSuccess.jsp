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
            <img src="<c:url value='/resources/img/success.jpg'/>" width="100px"/>
            <h4>${nombreEstudianteCSS}</h4>
            <p>
                FELICITACIONES
            </p>
            <P>
                HAS CERRADO UN CICLO MAS
            </P>

            <h6>
                TUS MATERIAS APROBADAS SE HAN ACTUALIZADO
            </h6>
            <h6>
                TIENES NUEVAS POSIBLES MATERIAS
            </h6>
        </div>

    </div>
    <div>
        <a href="${pageContext.request.contextPath}/mainPage">Ir a inicio</a>
    </div>

</body>
</html>