<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/partials/header.jsp"></jsp:include>
<main class="contenido">

    <section class="contenedor "  >

        <div class="card w-25 centrar ">
            <div class="card-body">
                <h2 class="text-center h2">Creacion de cursos</h2>
                <div class="d-flex align-content-center justify-content-center">
                    <form:form action="guardar-curso" method="post" modelAttribute="datosCurso" class=" ">
                        <div class="form-group  mb-2">
                            <label for="nombre">Nombre del curso</label>
                            <form:input path="nombre" id="nombre" class="form-control "></form:input>
                            <form:errors path="nombre"></form:errors>
                        </div>
                        <div class="form-group  mb-2">
                            <label for="cantidad">Cantidad maxima de Alumnos</label>
                            <form:input path="cantidadMaximaAlumnos" id="cantidad" class="form-control"></form:input>
                        </div>
                        <form:button type="submit" class="btn btn-primary mt-2">Crear Curso</form:button>
                    </form:form>

                </div>


            </div>
        </div>



    </section>


</main>
<footer>

</footer>

</body>
</html>