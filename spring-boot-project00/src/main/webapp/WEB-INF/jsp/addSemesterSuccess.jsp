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
      <img class="box" src="<c:url value='/resources/img/success.jpg'/>" width="50px"/>
            <h4>${nombreEstudianteASS}</h4>
            <p>
                HAS ACTUALIZADO TU CICLO
                EXITOSAMENTE
            </p>


        </div>

    </div>
    <div>
        <a href="${pageContext.request.contextPath}/availableSubjects">Regresar a Materias Habiles</a>
    </div>

</body>

</html>