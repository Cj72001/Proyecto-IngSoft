<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Subjects</title>
</head>

<body>
    <div class="main">
        <div class="box">
            <form method="post" action="subjectsUpdateSuccess">
                <img class="box"  src="<c:url value='/resources/img/login.jpg'/>" width="200px"/>
                <div class="box">
                    <input type="text" name="subject" placeholder="Nombre Materia"
                        onFocus="field_focus(this, 'subject');" onblur="field_blur(this, 'subject');" class="carnet" />
                    <label>Catedrático que agregara o editara</label>
                    <input type="text" name="professor" placeholder="Nombre Catedrático"
                        onFocus="field_focus(this, 'professor');" onblur="field_blur(this, 'professor');"
                        class="carnet" />
                        
                        <h3>${errorSU}</h3>
                        
                    <br> <input class="box2"type="submit" value="Editar Catedratico">
                </div> <!-- End Box -->
                </form>
                
                <form method="post" action="subjectsUpdateSuccess2">
                <div class="box">
                    <label>Evaluación que Agregara</label>
                    <input type="text" name="assessment" placeholder="Nombre Evaluación"
                        onFocus="field_focus(this, 'assessment');" onblur="field_blur(this, 'assessment');"
                        class="carnet" />
                    <input type="text" name="percentage" placeholder="Porcentaje Evaluación"
                        onFocus="field_focus(this, 'percentage');" onblur="field_blur(this, 'percentage');"
                        class="carnet" />
                    <input type="date" name="date" placeholder="Fecha"
                        onFocus="field_focus(this, 'date');" onblur="field_blur(this, 'date');"
                        class="carnet" />
                        
                         <h3>${errorSU2}</h3>
                    
                    <br> <input class="box2"type="submit" value="Agregar Evaluación">
                </div>
            </form>
            
        </div>

    </div>
    <div>
        <a href="${pageContext.request.contextPath}/semester">Regresar a Mi Ciclo</a>
    </div>

</body>

</html>