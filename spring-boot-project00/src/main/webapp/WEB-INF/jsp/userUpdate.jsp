<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Document</title>
</head>

<body>
    <div class="main">

        <form method="post" action="userUpdateSuccess">
        <img src="<c:url value='/resources/img/login.jpg'/>" width="10%"/>
            <div class="box">
                <input type="name" name="name" placeholder="Nuevo Nombre" onFocus="field_focus(this, 'nombre');"
                    onblur="field_blur(this, 'name');" class="carnet" />
                <input type="carnet" name="carnet" placeholder="Carnet" onFocus="field_focus(this, 'carnet');"
                    onblur="field_blur(this, 'carnet');" class="carnet" />
            </div> <!-- End Box -->
            
            <div> 
            <h3>${errorUU}</h3>
            <br> <input class="btn2" type="submit" value="Actualizar">
              
            </div>
            
        </form>

        <div>
            
            <div> 
                <a href="${pageContext.request.contextPath}/mainPage">Regresar a Mi Proceso</a>
            </div>

        </div>

    </div>

</body>

</html>