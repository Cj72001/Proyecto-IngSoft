<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Update Activities</title>
</head>


<body>
  <div class="main">
      
    <form method="post" action="activitiesUpSuccess">
    <img src="<c:url value='/resources/img/login.jpg'/>" width="200px"/>
      <div class="box">
        <input type="nameActivity" name="nameActivity" value="Nombre de actividad" onFocus="field_focus(this, 'nameActivity');" onblur="field_blur(this, 'nameActivity');" class="carnet" />
        
      </div> <!-- End Box -->
      <h3>${errorU}</h3>
      
    </form>
    
    <form method="post" action="activitiesUpSuccess">
    <br> <input class="btn2"type="submit" value="AGREGAR ACTIVIDAD">
    </form>
    
    <form method="post" action="activitiesUpSuccess2">
     <br> <input class="btn2"type="submit" value="ELIMINAR ACTIVIDAD">
    </form>

    
  </div>
  <div class="pading">
    <a href="${pageContext.request.contextPath}/activities">Regresar a Actividades</a>
</div>


  </div>

  




</body>
</html>