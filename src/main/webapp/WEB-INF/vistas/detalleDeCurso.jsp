<%--
  Created by IntelliJ IDEA.
  User: facun
  Date: 19/11/2021
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/partials/header.jsp"></jsp:include>


<main class="contenido">

    <div class="card w-50 centrar ">
        <div class="card-body">
            <h2 class="text-center">${datosCurso.nombre}</h2>
            <table class="table table-bordered table-light">
                <thead>
                <tr>

                    <th class="text-center">nombreAlumno</th>
                    <th class="text-center">apellido</th>
                    <th class="text-center">dni</th>
                    <th class="text-center">accion</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${datosCurso.alumnos}" var="alumno">
                    <tr>


                        <td class="text-center">${alumno.nombre} </td>
                        <td class="text-center">${alumno.apellido} </td>
                        <td class="text-center">${alumno.dni} </td>

                        <td>
                            <a href="borrar-alumno?idCurso=${datosCurso.id}&idAlumno=${alumno.id}"> Eliminar</a>
                        </td>

                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>


</main>

</body>


</html>
