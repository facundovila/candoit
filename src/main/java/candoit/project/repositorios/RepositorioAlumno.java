package candoit.project.repositorios;

import candoit.project.modelo.Alumno;

import java.util.List;

public interface RepositorioAlumno {

    void guardar(Alumno alumno);
    void eliminar(Alumno alumno);
    List<Alumno> traerAlumnos();

    Alumno getById(Long idAlumno);

}
