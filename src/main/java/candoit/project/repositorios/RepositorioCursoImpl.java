package candoit.project.repositorios;


import candoit.project.modelo.Alumno;
import candoit.project.modelo.Curso;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Repository("repositorioCurso")
public class RepositorioCursoImpl implements RepositorioCurso {

    private SessionFactory sessionFactory;


    @Autowired
    public RepositorioCursoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void agregar(Curso curso) {
        sessionFactory.getCurrentSession().save(curso);
    }


    @Override
    public List<Curso> listarCursos() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Curso.class)
                .list();

    }

    @Override
    public Curso getById(Long idCurso) {
        return (Curso) sessionFactory.getCurrentSession()
                .createCriteria(Curso.class)
                .add(Restrictions.eq("id", idCurso))
                .uniqueResult();
    }

    @Override
    public boolean eliminarAlumno(Long idCurso, Long idAlumno) {
        var curso = getById(idCurso);

        var listaAlumno = curso.getAlumnos();

        if (listaAlumno == null) {
            listaAlumno = new ArrayList<>();
        }

        var pos = -1;

        for (int i = 0; i < listaAlumno.size(); i++) {
            var alumno = listaAlumno.get(i);

            if (alumno.getId().equals(idAlumno)) {
                pos = i;

                break;
            }
        }

        if (pos > -1) {
            listaAlumno.remove(pos);

            sessionFactory.getCurrentSession().update(curso);

            return true;
        } else {
            return false;
        }
    }

}
