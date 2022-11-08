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
        <img src="<c:url value='/resources/img/activities.jpg'/>" width="50px"/>
    </div>

    <div>
        <table class="tabla" border="1px" class="tabla2">

            <tr>
                <td bgcolor="#e5e5e5"> Nombre de la actividad</td>
                <td bgcolor="#e5e5e5"> Estado </td>
            </tr>
            <tr>
                <td> ${nombreActividad1}</td>
                <td> <label><input type="checkbox" id="cbox1" value="first_checkbox"></label><br> </td>
            </tr>
            <tr>
                <td> ${nombreActividad2}</td>
                <td><label><input type="checkbox" id="cbox1" value="first_checkbox"></label><br> </td>
            </tr>
            <tr>
                <td> ${nombreActividad3}</td>
                <td> <label><input type="checkbox" id="cbox1" value="first_checkbox"></label><br> </td>
            </tr>
            <tr>
                <td> ${nombreActividad4}</td>
                <td> <label><input type="checkbox" id="cbox1" value="first_checkbox"></label><br> </td>
            </tr>

    </div>

    <div class="down">
        <a href="${pageContext.request.contextPath}/activitiesUpdate">
            <div class="btn2">AGREGAR ACTIVIDAD</div>
        </a> <!-- End Btn -->
    </div>


</body>

</html>