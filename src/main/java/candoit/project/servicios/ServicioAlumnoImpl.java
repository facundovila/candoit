package candoit.project.servicios;

import candoit.project.controladores.DatosAlumno;
import candoit.project.modelo.Alumno;
import candoit.project.modelo.Curso;
import candoit.project.repositorios.RepositorioAlumno;
import candoit.project.repositorios.RepositorioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ServicioAlumnoImpl implements ServicioAlumno {

    private RepositorioAlumno repositorioAlumno;
    private RepositorioCurso repositorioCurso;

    @Autowired
    public ServicioAlumnoImpl(RepositorioAlumno repositorioAlumno, RepositorioCurso repositorioCurso) {

        this.repositorioAlumno = repositorioAlumno;
        this.repositorioCurso = repositorioCurso;
    }

    @Override
    public Alumno guardar(DatosAlumno datosAlumno) {
        if (datosAlumno.getNombre() == null) throw new CampoVacioException();

        Curso cursos = repositorioCurso.getById(datosAlumno.getIdCurso());
        Alumno alumno = new Alumno(datosAlumno);
        alumno.agregarCurso(cursos);
        cursos.agregarAlumno(alumno);
        repositorioAlumno.guardar(alumno);


        return alumno;
    }


    @Override
    public List<Alumno> listarAlumnos() {
        return repositorioAlumno.traerAlumnos();
    }


}
