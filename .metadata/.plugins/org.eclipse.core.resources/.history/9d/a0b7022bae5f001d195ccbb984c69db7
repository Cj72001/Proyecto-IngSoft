<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Main Page</title>
</head>

<body>
<!-- inluyendo header -->
    <%@include file="/WEB-INF/jsp/header.jsp" %>
    
    <div>
        <div class="flex-container">
            <div>
                <h1>${nombreEstudiante}</h1>
                <p>${anioEstudiante}</p>
                
                <a href="${pageContext.request.contextPath}/dataUpdate">
                    <div class="btn2" class="padding6">EDITAR USUARIO</div>
                </a>
                
            </div>
            <div>

            </div>
            <div>
            <img src="<c:url value='/resources/img/user.jpg'/>" width="40%"/>

            </div>
        </div>

        <div class="flex-container2">
            <div>
            <img src="<c:url value='/resources/img/control.jpg'/>" width="20%"/>
                <h2>Materias</h2>
                <p>Tienes un total de <b>${numeroMateriasAprobadasEstudiante}</b></p>
                <p>Materias aprobadas</p>
            </div>

            <div>
            <img src="<c:url value='/resources/img/semester.jpg'/>" width="25%"/>
                <h2>CUM</h2>
                <p>Tienes un CUM total de carrera de</p>
                <p>de <b>${cumEstudiante}</b></p>
            </div>
            <div>
            <img src="<c:url value='/resources/img/subjects.jpg'/>" width="16%"/>
                <h2>UV</h2>
                <p>Tienes un total de <b>${uVEstudiante}</b></p>
                <p>unidades valorativas pasadas</p>

            </div>
        </div>
        <div class="flex-container2">
            <div>
            <img src="<c:url value='/resources/img/progress.jpg'/>" width="20%"/>
                <h2>Avance de carrera</h2>
                <p>Tienes un avance del</p>
                <p><b>${avanceCarreraEstudiante}</b>% de tu carrera</p>
            </div>

            <div>
            <img src="<c:url value='/resources/img/activities.jpg'/>" width="20%"/>
                <h2>Posibles</h2>
                <p>Tienes un total de <b>${materiasDisponiblesEstudiante}</b></p>
                <p>Posibles opciones de Materias</p>
            </div>
            <div>
            <img src="<c:url value='/resources/img/schedule.jpg'/>" width="20%"/>
                <h2>Horas Sociales</h2>
                <p>Tienes un total de <b>${horasInternasEstudiante}</b></p>
                <p>horas sociales internas y <b>${horasExternasEstudiante}</b></p>
                <p>externas realizadas</p>

            </div>
        </div>

    </div>



</body>

</html>