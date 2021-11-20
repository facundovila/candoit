package candoit.project.servicios;

import candoit.project.controladores.DatosCurso;
import candoit.project.modelo.Curso;
import candoit.project.repositorios.RepositorioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ServicioCursoImpl implements ServicioCurso {

    private RepositorioCurso repositorioCurso;


    @Autowired
    public ServicioCursoImpl(RepositorioCurso repositorioCurso) {
        this.repositorioCurso = repositorioCurso;
    }


    public Curso guardar(DatosCurso datosCurso) {
        if (datosCurso.getNombre() == null) throw new CampoVacioException();

        Curso curso = new Curso(datosCurso);

        repositorioCurso.agregar(curso);

        return curso;

    }

    @Override
    public List<Curso> listarTodas() {
        return repositorioCurso.listarCursos();
    }


    @Override
    public void eliminarAlumno(Long idCurso, Long idAlumno) {
        repositorioCurso.eliminarAlumno(idCurso, idAlumno);
    }

    @Override
    public Curso getById(Long idCurso) {
        return repositorioCurso.getById(idCurso);
    }
}
