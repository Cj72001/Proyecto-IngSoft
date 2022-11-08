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
        	<img src="<c:url value='/resources/img/control.jpg'/>" width="50px"/>


            <h5 class="posicion1">ARQUITECTURA DE COMPUTADORAS </h5>
        </div>

    </div>

    <div class="padding2">
        <table class="tabla" border="1px">

            <tr>
                <td bgcolor="#e5e5e5">Evaluacion</td>
                <td bgcolor="#e5e5e5">Ponderacion </td>
                <td bgcolor="#e5e5e5">Fecha de realizacion</td>
                <td bgcolor="#e5e5e5">Nota</td>
            </tr>

            <tr>
                <td> Primer Parcial</td>
                <td> 20.0</td>
                <td> 31/03/2022</td>
                <td bgcolor="green"> 7.0</td>



            </tr>
            <tr>
                <td> Primer Parcial</td>
                <td> 20.0</td>
                <td> 31/03/2022</td>
                <td bgcolor="green"> 7.0</td>


            </tr>
            <tr>
                <td> Primer Parcial</td>
                <td> 20.0</td>
                <td> 31/03/2022</td>
                <td bgcolor="green"> 7.0</td>

            </tr>


    </div>
    <div class="posicion">
        <h5>ARQUITECTURA DE COMPUTADORAS </h5>
    </div>

    <div>


        <table class="tabla2" border="1px">

            <tr>
                <td bgcolor="#e5e5e5">Evaluacion</td>
                <td bgcolor="#e5e5e5">Ponderacion </td>
                <td bgcolor="#e5e5e5">Fecha de realizacion</td>
                <td bgcolor="#e5e5e5">Nota</td>
            </tr>

            <tr>
                <td> Primer Parcial</td>
                <td> 20.0</td>
                <td> 31/03/2022</td>
                <td bgcolor="green"> 7.0</td>



            </tr>
            <tr>
                <td> Primer Parcial</td>
                <td> 20.0</td>
                <td> 31/03/2022</td>
                <td bgcolor="green"> 7.0</td>


            </tr>
            <tr>
                <td> Primer Parcial</td>
                <td> 20.0</td>
                <td> 31/03/2022</td>
                <td bgcolor="green"> 7.0</td>
            </tr>


    </div>
    <div class="posicion2">

    </div>






</body>

</html>