<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

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

    <div class="box">
        <div>
            <h4 class="colordiv">
                Estas son las materias que puedes inscribir
            </h4>
            <img src="<c:url value='/resources/img/subjects.jpg'/>" width="50px"/>
        </div>

        <div>
            <table class="tabla" border="1px">

                <tr>
                    <td bgcolor="#e5e5e5"> Nombre de la materia</td>
                    <td bgcolor="#e5e5e5"> UV's </td>
                    <td bgcolor="#e5e5e5"> Prerequisito </td>
                </tr>
                <tr>
                    <td>
                        ${NombreMateria1}
                    </td>
                    <td>
                        ${UV1}
                    </td>
                    <td>
                        ${Prerrequisito1}
                    </td>
                </tr>
                <tr>
                    <td>
                        ${NombreMateria2}
                    </td>
                    <td>
                        ${UV2}
                    </td>
                    <td>
                        ${Prerrequisito2}
                    </td>
                </tr>
                <tr>
                    <td>
                        ${NombreMateria3}
                    </td>
                    <td>
                        ${UV3}
                    </td>
                    <td>
                        ${Prerrequisito3}
                    </td>
                </tr>
                <tr>
                    <td>
                        ${NombreMateria4}
                    </td>
                    <td>
                        ${UV4}
                    </td>
                    <td>
                        ${Prerrequisito4}
                    </td>
                </tr>
            </table>
        </div>

    <div class="box">
        <form method="post" action="addSubject">
            <div class="position5">
                <input type="materia" name="materia" placeholder="Nombre Materia" onFocus="field_focus(this, 'materia');" onblur="field_blur(this, 'materia');" class="materia" />
            </div> <!-- End Box -->
          
          <h3>${errorASS}</h3>
      <!-- Agregarle stilo a estos botones "class = btn2"-->
      <br> <input class="position5" type="submit" value="Agregar Ciclo">
        </form>
    </div>


</body>

</html>