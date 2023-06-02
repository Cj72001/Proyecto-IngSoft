<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Subjects Update</title>
</head>
<body>
    <div class="main">
        <div class="box">
        <img src="<c:url value='/resources/img/success.jpg'/>" width="100px"/>
            <h4>${nombreEstudianteUS}</h4>
            <P>
                HAS ACTUALIZADO LA MATERIA EXITOSAMENTE
            </P>
        </div>

    </div>
    <div>
        <a class="btn2" href="${pageContext.request.contextPath}/semester">Regresar a mi Ciclo</a>
    </div>

</body>
</html>