package candoit.project.modelo;


import candoit.project.controladores.DatosAlumno;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer dni;

    @ManyToMany(mappedBy = "alumnos", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Curso> cursos;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, message = "nombre invalido")
    private String nombre;

    @NotNull
    @Size(min = 3, message = "apellido invalido")
    private String apellido;

    public Alumno() {
    }


    public Alumno(DatosAlumno datosAlumno) {
        this.nombre = datosAlumno.getNombre();
        this.dni = datosAlumno.getDni();
        this.apellido = datosAlumno.getApellido();
        this.cursos = new ArrayList<>();
    }


    public List<Curso> agregarCurso(Curso curso) {
        this.cursos.add(curso);
        return cursos;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
