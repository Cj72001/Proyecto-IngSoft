<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Available Subjects</title>
</head>

<body>
    <!-- inluyendo header -->
    <%@include file="/WEB-INF/jsp/header.jsp" %>
    
    <di>
        <div>
            <h4 class="colordiv">
                Estas son las materias que puedes inscribir
            </h4>
            <img src="<c:url value='/resources/img/subjects.jpg'/>" width="25px"/>
        </div>
        
        <h1 class="colordiv">
                ${errorSem3}
         </h1>
    
        <div>
            <table class="tablaNormal" border="1px">

                <tr>
                	<td bgcolor="#e5e5e5"> Numero Correlativo</td>
                    <td bgcolor="#e5e5e5"> Nombre de la materia</td>
                    <td bgcolor="#e5e5e5"> UV's </td>
                    <td bgcolor="#e5e5e5"> Prerequisito </td>
                </tr>
                
                <c:forEach var="m" items="${materias}">
		
				<tr>
                <td>${m.getIdMateria()}</td>
                <td>${m.getNombreMateria()}</td>
                <td>${m.getUv()}</td>
                <td>${m.getPreRequisito()}</td>
                </tr>
			
				</c:forEach>
		
            </table>
        </div>

    <form method="post" action="subjectsUpdateSuccess">
                <div class="box">
                
                <label>Materia que agregara</label>
                    <input type="text" name="subject" placeholder="Números Correlativo de la materia"
                        onFocus="field_focus(this, 'subject');" onblur="field_blur(this, 'subject');" class="carnet" />
                    
                    <input type="text" name="professor" placeholder="Nombre Catedrático"
                        onFocus="field_focus(this, 'professor');" onblur="field_blur(this, 'professor');"
                        class="carnet" />
                        
                        <h3>${errorSU}</h3>
                        
                    <br> <input class="btn2" type="submit" value="Editar Materia">
                </div> <!-- End Box --> 
                </form>
                


</body>

</html>