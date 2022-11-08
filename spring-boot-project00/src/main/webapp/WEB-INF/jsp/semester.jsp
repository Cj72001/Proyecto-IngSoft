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

    <div class="box">
        <div>
            <h2 class="colordiv">
                Ciclo 01/2022
            </h2>
            <img src="<c:url value='/resources/img/semester.jpg'/>" width="50px"/>
            <h4 class="colordiv">
                ARQUITECTURA DE COMPUTADORAS
            </h4>
            <h6>Ing. Gabriela Reynosa</h6>
        </div>

        <div>
            <table class="tabla" border="1px">

                <tr>
                    <td bgcolor="#e5e5e5"> Nombre de la actividad</td>
                    <td bgcolor="#e5e5e5"> Estado </td>
                    <td bgcolor="#e5e5e5"> Fecha </td>
                    <td bgcolor="#e5e5e5"> Nota </td>
                </tr>
                <tr>
                    <td>
                        Primer Parcial
                    </td>
                    <td>
                        20.0
                    </td>
                    <td>
                        31/03/2022
                    </td>
                    <td>
                        7.8
                    </td>
                </tr>
                <tr>
                    <td>
                        Segundo Parcial
                    </td>
                    <td>
                        40.0
                    </td>
                    <td>
                        24/05/2022
                    </td>
                    <td>

                    </td>
                </tr>
                <tr>
                    <td>
                        Tercer Parcial
                    </td>
                    <td>
                        40.0
                    </td>
                    <td>
                        01/07/2022
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </div>

        <div class="box">
            <div class="position3">
                <h4 class="colordiv">
                    TECNICAS DE SIMULACION EN COMPUTADORAS
                </h4>
                <h6>Ing. Enmanuel Araujo</h6>
            </div>

            <table border="1px" class="tabla2">

                <tr>
                    <td bgcolor="#e5e5e5"> Nombre de la actividad</td>
                    <td bgcolor="#e5e5e5"> Estado </td>
                    <td bgcolor="#e5e5e5"> Fecha </td>
                    <td bgcolor="#e5e5e5"> Nota </td>
                </tr>
                <tr>
                    <td>
                        Primer Parcial
                    </td>
                    <td>
                        20.0
                    </td>
                    <td>
                        31/03/2022
                    </td>
                    <td>
                        7.8
                    </td>
                </tr>
                <tr>
                    <td>
                        Segundo Parcial
                    </td>
                    <td>
                        40.0
                    </td>
                    <td>
                        24/05/2022
                    </td>
                    <td>

                    </td>
                </tr>
                <tr>
                    <td>
                        Tercer Parcial
                    </td>
                    <td>
                        40.0
                    </td>
                    <td>
                        01/07/2022
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </div>
    </div>


    <div class="box">
        <div class="position4">
            <a href="${pageContext.request.contextPath}/subjectsUpdate">
                <div class="btn2">Editar Materias</div>
            </a> <!-- End Btn -->
        </div>
        <div  class="position5">
            <a href="${pageContext.request.contextPath}/closeSemester">
                <div class="btn2">Cerrar Ciclo</div>
            </a> <!-- End Btn -->
        </div>
    </div>

</body>

</html>