<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Actividades</title>
</head>

<body>
    <!-- inluyendo header -->
    <%@include file="/WEB-INF/jsp/header.jsp" %>

    <div>
        <h2 class="padding">
            ESTAS SON TUS ACTIVIDADES

        </h2>
        <img src="<c:url value='/resources/img/activities.jpg'/>" width="25px"/>
    </div>

    <div>
        <table class="tablaActivities" border="1px">

            <tr>
            	<td bgcolor="#e5e5e5">Numero de la actividad</td>
                <td bgcolor="#e5e5e5">Nombre de la actividad</td>
            </tr>
            
            <c:forEach var="a" items="${actividadesEstudianteLogeado}">
            <tr>
            	<td> ${a.getIdActividadesExtra()}</td>
                <td> ${a.getNombreActividadesExtra()}</td>
            </tr>
            </c:forEach>
            
		 </table>
    </div>

    
    <form method="post" action="activitiesEdit">
    
      <div class="box">
        <input type="text" name="idActivity" placeholder="Numero de la actividad" onFocus="field_focus(this, 'nameActivity');" onblur="field_blur(this, 'nameActivity');" class="carnet" />
        <input type="text" name="nombreActividad" placeholder="Nombre de la actividad" onFocus="field_focus(this, 'nameActivity');" onblur="field_blur(this, 'nameActivity');" class="carnet" />
        
      </div> <!-- End Box -->
      <h3>${errorAE}</h3>
      
      <br> <input class="btn2"type="submit" value="EDITAR ACTIVIDAD">
      
    </form>


</body>

</html>