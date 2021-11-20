<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/partials/header.jsp"></jsp:include>
<main class="contenido">

    <div class="card w-50 centrar ">
        <div class="card-body">
            <h2 class="mb-3 text-center">Lista De alumnos</h2>
            <div class="container">

                <table class="table table-bordered table-light">
                    <thead>
                    <tr>

                        <th class="text-center">Nombre</th>
                        <th class="text-center">apellido</th>
                        <th class="text-center">dni</th>
                        <th class="text-center">curso</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listaAlumnos}" var="alumno">
                        <tr>

                            <td class="text-center">${alumno.nombre}</td>
                            <td class="text-center">${alumno.apellido} </td>
                            <td class="text-center">${alumno.dni} </td>

                            <c:forEach items="${alumno.cursos}" var="curso">
                                <td class="text-center">${curso.nombre} </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <a class="btn btn-primary" href="crear-alumno">Crear Alumno</a>

            </div>
        </div>
    </div>


</main>

</body>
</html>
