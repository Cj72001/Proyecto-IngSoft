<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <title>Recuperación de Contraseña</title>
</head>

<body>
    <div class="main">

        <form method="post" action="actualizarContrasena">
        <img  src="<c:url value='/resources/img/login.jpg'/>" width="100px"/>
            <div class="box">
                <input type="text" name="nombrePR" placeholder="Nombre Completo" onFocus="field_focus(this, 'nombre');"
                    onblur="field_blur(this, 'nombre');" class="carnet" />
                <input type="carnet" name="carnetPR" placeholder="Carnet" onFocus="field_focus(this, 'carnet');"
                    onblur="field_blur(this, 'carnet');" class="carnet" />
                <input type="password" name="passwordPR" placeholder="Nueva Contraseña" onFocus="field_focus(this, 'password');"
                    onblur="field_blur(this, 'password');" class="carnet" /> 
                    <h3>${errorPR}</h3>
            </div> <!-- End Box -->
            <br> <input class="btn4" type="submit" value="ACTUALIZAR CONTRASENA">
            
        </form>
        
      <div>
        <a href="${pageContext.request.contextPath}/login">Login</a>
      </div>
	  

    </div>

</body>

</html>