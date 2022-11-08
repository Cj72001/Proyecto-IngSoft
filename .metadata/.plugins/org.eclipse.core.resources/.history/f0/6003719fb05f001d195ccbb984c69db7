<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Calcular Notas</title>
</head>

<body>
    <!-- inluyendo header -->
    <%@include file="/WEB-INF/jsp/header.jsp" %>

    <div>
        <h2 class="padding">
            ESTE ES TU CONTROL DE NOTAS

        </h2>
        
        
        
        <div>
        	<img src="<c:url value='/resources/img/control.jpg'/>" width="25px"/>
        </div>
        
        <h1 class="colordiv">
                ${errorCS}
         </h1>

    </div>

    <div>
   
   <c:forEach var="mm" items="${misMateriasELCS}">
   
    <h5 class="posicion1">${mm.getNombreMateria()}</h5>
    
    
        <table class="tablaScore" border="1px">
        
            <tr>
                <td bgcolor="#e5e5e5">Evaluacion</td>
                <td bgcolor="#e5e5e5">Ponderacion </td>
                <td bgcolor="#e5e5e5">Fecha de realizacion</td>
                <td bgcolor="#e5e5e5">Nota</td>
            </tr>

			<c:forEach var="e" items="${evaluacionesCS}">
       		 <c:choose>
       		 
        	<c:when test ="${ e.getIdMateria().equals( mm.getIdMateria() ) }">
            <tr>
                <td>${e.getEvaluacion()}</td>
                <td>${e.getPonderacion()}</td>
                <td>${e.getFecha()}</td>
                <td bgcolor="green"> ${e.getNota()} </td>
            </tr>
            </c:when>
            
            
		</c:choose>
		</c:forEach>
		
		</table>
		</c:forEach>
		
    </div>
    
   

</body>

</html>