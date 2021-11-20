package candoit.project.servicios;

import candoit.project.controladores.DatosAlumno;
import candoit.project.modelo.Alumno;
import candoit.project.modelo.Curso;

import java.util.List;

public interface ServicioAlumno {

    Alumno guardar(DatosAlumno datosAlumno);

    //Alumno guardar(String nombre,Integer dni, List<Curso> cursos);


    List<Alumno> listarAlumnos();

}
