<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Data Update</title>
</head>
<body>

    <div class="flex-container2">  
    <div class="main">
        <div class="box">
        <img src="<c:url value='/resources/img/userupdate.jpg'/>" width="50%"/>
            <div>
                <a href="${pageContext.request.contextPath}/userUpdate"><div class="box2">Actualizar Usuario</div></a> <!-- End Btn -->
            </div>
        </div>

    </div>
    <hr/>
    <div class="main">
        <div class="box">
         <img src="<c:url value='/resources/img/schedule.jpg'/>" width="50%"/>
            <div>
                <a href="${pageContext.request.contextPath}/socialUpdate"><div class="box2">Actualizar Horas Sociales</div></a> <!-- End Btn -->
            </div>
        </div>

    </div>
    
    </div> 
    <div>
        <a href="${pageContext.request.contextPath}/mainPage">Regresar al Inicio</a>
    </div>

</body>
</html>