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



        
        	<h2 class="colordiv">
                Materias del ciclo actual
            </h2>
            
            <h4 class="colordiv">
                ${errorSem2}
            </h4>
            
        
            <table class="tablaNormal" border="1px">
            
            
                <tr>
                    <td bgcolor="#e5e5e5"> Nombre de la materia</td>
                    <td bgcolor="#e5e5e5"> Numero Correlativo </td>
                </tr>
                
                <c:forEach var="mm2" items="${misMateriasEL2}">
                <tr>
                <td>${mm2.getNombreMateria()}</td>
                <td>${mm2.getIdMateria()}</td>
                </tr>
                </c:forEach>
                
    
            </table>
            
            
    <div class="main">
        <div class="box">
        
            
                <form method="post" action="subjectsUpdateSuccess2">
                <div class="box">
                    <label>Evaluación que Agregara</label>
                    <input type="text" name="subject" placeholder="Números Correlativo de la materia"
                        onFocus="field_focus(this, 'subject');" onblur="field_blur(this, 'subject');" class="carnet" />
                    <input type="text" name="nameEvaluation" placeholder="Nombre Evaluación"
                        onFocus="field_focus(this, 'assessment');" onblur="field_blur(this, 'assessment');"
                        class="carnet" />
                    <input type="text" name="percentageEvaluation" placeholder="Porcentaje Evaluación"
                        onFocus="field_focus(this, 'percentage');" onblur="field_blur(this, 'percentage');"
                        class="carnet" />
                        <input type="text" name="scoreEvaluation" placeholder="Nota Evaluación"
                        onFocus="field_focus(this, 'percentage');" onblur="field_blur(this, 'percentage');"
                        class="carnet" />
                    <input type="date" name="dateEvaluation" placeholder="Fecha"
                        onFocus="field_focus(this, 'date');" onblur="field_blur(this, 'date');"
                        class="carnet" />
                        
                         <h3>${errorSU2}</h3>
                    
                    <br> <input class="btn2"type="submit" value="Editar Evaluación">
                </div>
            </form>
            
        </div>

    </div>
    <div class="padding">
        <a href="${pageContext.request.contextPath}/semester">Regresar a Mi Ciclo</a>
    </div>

</body>

</html>