package candoit.project.servicios;

import candoit.project.controladores.DatosCurso;
import candoit.project.modelo.Curso;

import java.util.List;

public interface ServicioCurso {
    Curso guardar(DatosCurso datosCurso);
    List<Curso> listarTodas();
    void eliminarAlumno(Long idCurso, Long idAlumno);
    Curso getById(Long idCurso);
}
