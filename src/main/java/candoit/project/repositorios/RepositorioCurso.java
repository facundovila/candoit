package candoit.project.repositorios;

import candoit.project.modelo.Curso;

import java.util.List;

public interface RepositorioCurso {

    void agregar(Curso curso);

    List<Curso> listarCursos();


    boolean eliminarAlumno(Long idCurso, Long idAlumno);

    Curso getById(Long idCurso);

}
