<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Login</title>
</head>

<body>
  <div class="main">
      
    <form method="post" action="loginn">
      <img  src="<c:url value='/resources/img/login.jpg'/>" width="100px"/>
      <div class="box">
        <input type="carnet" name="CARNET" placeholder="Carnet" onFocus="field_focus(this, 'carnet');" onblur="field_blur(this, 'carnet');" class="carnet" />
        <input type="password" name="PASSWORD" placeholder="Contraseña" onFocus="field_focus(this, 'password');" onblur="field_blur(this, 'password');" class="carnet" />
      </div>
      
      <h3>${errorL}</h3>
      
      <!-- Agregarle stilo a estos botones -->
      
      <br> <input class="btn4" type="submit" value="ENTRAR">
      
    </form>

    <div>
      <div>
        <a href="${pageContext.request.contextPath}/recoveryPasword">Recuperar contraseña</a>
      </div>
      <div>
        <a href="${pageContext.request.contextPath}/register">Registrarse</a>
      </div>
    
  </div>

  </div>

</body>
</html>