<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/partials/header.jsp"></jsp:include>
<main class="contenido">
    <div class="card w-50 centrar ">
        <div class="card-body">
            <h2 class="mb-3 text-center">Lista De cursos</h2>
            <div class="contenedor container">
                <table class="table table-bordered table-light">
                    <thead>
                    <tr>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Capacidad Máxima</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listaCursos}" var="curso">
                        <tr>

                            <td class="text-center"><a href="detalle-curso?idCurso=${curso.id}">${curso.nombre}</a></td>
                            <td class="text-center">${curso.cantidadMaximaAlumnos} </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <a class="btn btn-primary" href="crear-curso">Crear curso</a>
            </div>
        </div>


    </div>


</main>

</body>
</html>
