<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Registro</title>
</head>
<body>
    <div class="main">

        <form method="post" action="registrarEstudiante">
        <img  src="<c:url value='/resources/img/login.jpg'/>" width="100px"/>
            <div class="box">
                <input type="text" name="nombreRe" placeholder="Nombre Completo" onFocus="field_focus(this, 'nombre');"
                    onblur="field_blur(this, 'nombre');" class="carnet" />
                <input type="carnet" name="carnetRe" placeholder="Carnet" onFocus="field_focus(this, 'carnet');"
                    onblur="field_blur(this, 'carnet');" class="carnet" />
                <input type="password" name="passwordRe" placeholder="Contraseña" onFocus="field_focus(this, 'password');"
                    onblur="field_blur(this, 'password');" class="carnet" /> 
                <input type="password" name="passwordRe2" placeholder="Repita Contraseña" onFocus="field_focus(this, 'password');"
                    onblur="field_blur(this, 'password');" class="carnet" /> 
            <h3>${errorRe}</h3>
            </div> <!-- End Box -->
            <br> <input class="btn4" type="submit" value="REGISTRARSE">
        </form>

        <div class="padding">
        <a href="${pageContext.request.contextPath}/login">Login</a>
      </div>

    </div>

</body>
</html>