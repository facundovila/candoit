<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/estilos.css">
    <title>candoit</title>
</head>
<body>
<header>
    <div class="encabezado">
        <h1> CandoIt</h1>
    </div>
    <nav class="menu" id="menu">

        <ul>
            <li><a class="activo" href="">INICIO</a></li>
            <li><a href="crear-curso">Crear Curso</a></li>
            <li><a href="crear-alumno">Crear Alumno</a></li>
            <li><a href="mostrar-cursos">Lista de Cursos</a></li>
            <li><a href="mostrar-alumnos">Lista de Alumnos</a></li>
        </ul>
    </nav>

</header>
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
    <div class="padding">

    </div>

</main>
<footer>

</footer>

</body>
</html>