package candoit.project.repositorios;

import candoit.project.modelo.Alumno;
import candoit.project.modelo.Curso;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("repositorioAlumno")
public class RepositorioAlumnoImpl implements RepositorioAlumno {
    private SessionFactory sessionFactory;


    @Autowired
    public RepositorioAlumnoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void guardar(Alumno alumno) {
        sessionFactory.getCurrentSession().save(alumno);
    }

    @Override
    public void eliminar(Alumno alumno) {
        sessionFactory.getCurrentSession().delete(alumno);
    }

    @Override
    public List<Alumno> traerAlumnos() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Alumno.class)
                .list();
    }

    @Override
    public Alumno getById(Long idAlumno) {
        return (Alumno) sessionFactory.getCurrentSession()
                .createCriteria(Alumno.class)
                .add(Restrictions.eq("id", idAlumno))
                .uniqueResult();
    }


}
