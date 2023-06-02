<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Semester</title>
</head>

<body>
    <!-- inluyendo header -->
    <%@include file="/WEB-INF/jsp/header.jsp" %>

    <div>
        <div>
            <h2 class="colordiv">
                Ciclo
            </h2>
            <img src="<c:url value='/resources/img/semester.jpg'/>" width="50px"/>
            
        </div>
        
        <h1 class="colordiv">
                ${errorSem}
         </h1>
            
        <div>
        
      
      
        
        <c:forEach var="mm" items="${misMateriasEL}">
        
        	<h4 class="colordiv">
                ${mm.getNombreMateria()}
            </h4>
            
            <h6>${mm.getCatedratico()}</h6>
        
            <table class="tablaNormal" border="1px">

                <tr>
                    <td bgcolor="#e5e5e5"> Nombre de la actividad</td>
                    <td bgcolor="#e5e5e5"> Ponderacion </td>
                    <td bgcolor="#e5e5e5"> Fecha </td>
                    <td bgcolor="#e5e5e5"> Nota </td>
                </tr>
                
                <c:forEach var="e" items="${evaluaciones}">
                <c:choose>
                
                <c:when test ="${ e.getIdMateria().equals( mm.getIdMateria() ) }">
                <tr>
                <td>${e.getEvaluacion()}</td>
                <td>${e.getPonderacion()}</td>
                <td>${e.getFecha()}</td>
                <td>${e.getNota()}</td>
                </tr>
                </c:when>
                
                
                </c:choose>
                </c:forEach>
    			
 
            </table>
            </c:forEach>
            
        </div>
        
    <div>
        <div >
            <a href="${pageContext.request.contextPath}/subjectsUpdate">
                <div class="btn2">Editar Materias</div>
            </a> <!-- End Btn -->
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/closeSemester">
                <div class="btn2">Cerrar Ciclo</div>
            </a> <!-- End Btn -->
        </div>
    </div>

</body>

</html>