<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/partials/header.jsp"></jsp:include>
<main class="contenido">
    <div class="card w-50 centrar ">
        <div class="card-body  ">
            <h2 class="text-center h2">Alta de Alumno</h2>
            <form:form action="guardar-alumno" method="post" modelAttribute="datosAlumnos" id="formulario">
                <div class="form-group  mb-2">
                    <label for="nombre">Nombre</label>
                    <form:input path="nombre" placeholder="ingrese nombre" id="nombreyapellido" class="form-control "/>
                    <form:errors path="nombre"/>
                </div>
                <div class="form-group  mb-2">
                    <label for="apellido">apellido</label>
                    <form:input path="apellido" placeholder="ingrese apellido" id="nombreyapellido"
                                class="form-control "/>
                    <form:errors path="apellido"/>

                </div>


                <div class="form-group mb-2">
                    <label for="dni">Dni</label>
                    <form:input path="dni" placeholder="ingrese dni  " id="dni" class="form-control "/>
                    <form:errors path="dni"/>
                </div>

                <div>
                    <label for="curso"> cursos disponibles</label>
                    <form:select path="idCurso" id="curso" class="custom-select">
                        <c:forEach items="${cursos}" var="curso">
                            <form:option value="${curso.id}"> ${curso.nombre}</form:option>
                        </c:forEach>
                    </form:select>
                </div>

                <form:button type="submit" class="btn btn-primary mt-2">Guardar</form:button>

                <div id="mensaje" class="error"></div>
            </form:form>
        </div>
    </div>

</main>

</body>
</html>
