<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Register Update</title>
</head>
<body>
    <div class="main">
        <div class="box">
            <img src="<c:url value='/resources/img/success.jpg'/>" width="100px"/>
            <h4>${nombreEstudianteRegistrado}</h4>
            <P>
                BIENVENIDO
            </P>
            <p>
                TE HAS REGISTRADO EXITOSAMENTE
            </p>
        </div>

    </div>
    
    <div class="padding">
        <a href="${pageContext.request.contextPath}/login">Login</a>
      </div>

</body>
</html>