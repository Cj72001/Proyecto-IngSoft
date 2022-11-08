<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Social Hours</title>
</head>

<body>
    <div class="main">

        <form method="post" action="socialUpdate">
        <img src="<c:url value='/resources/img/schedule.jpg'/>" width="100px"/>
            <div class="box">
                <input type="number" name="internal" placeholder="Horas Sociales Internas"
                    onFocus="field_focus(this, 'internal');" onblur="field_blur(this, 'internal');" class="carnet" />
                
                <br> <input class="btn4" type="submit" value="ACTUALIZAR HORAS INTERNAS">
                
                <h3>${errorSoU}</h3>
                </form>
                
                <form method="post" action="socialUpdate2">
                <input type="number" name="external" placeholder="Horas Sociales Externas"
                    onFocus="field_focus(this, 'external');" onblur="field_blur(this, 'external');" class="carnet" />
               
                <br> <input class="btn4" type="submit" value="ACTUALIZAR HORAS EXTERNAS">
                <h3>${errorSoU2}</h3>
            </div> <!-- End Box -->
        </form>

        <div>
        <a href="${pageContext.request.contextPath}/mainPage">Regresar a Mi Proceso</a>
      </div>

    </div>

</body>

</html>