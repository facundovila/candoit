package candoit.project.repositorios;

import candoit.project.SpringTest;
import candoit.project.modelo.Alumno;
import candoit.project.modelo.Curso;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

public class CursoTest extends SpringTest {
    @Autowired
    private RepositorioCurso repositorioCurso;

    @Autowired
    private RepositorioAlumno repositorioAlumno;

    @Test
    @Rollback
    @Transactional
    public void eliminarAlumnoDeUnCurso() {
        var a1 = new Alumno();
        a1.setNombre("1");
        repositorioAlumno.guardar(a1);

        var a2 = new Alumno();
        a2.setNombre("2");
        repositorioAlumno.guardar(a2);

        var curso = new Curso();
        curso.setNombre("curso");
        curso.agregarAlumno(a1);
        curso.agregarAlumno(a2);
        repositorioCurso.agregar(curso);

        repositorioCurso.eliminarAlumno(curso.getId(), a1.getId());

        Assert.assertFalse(curso.getAlumnos().contains(a1));
    }
}
