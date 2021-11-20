package candoit.project.modelo;


import candoit.project.controladores.DatosCurso;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "alumno_curso",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id")
    )
    List<Alumno> alumnos;



    @NotNull(message = "nombre invalido")
    @Size(min=3, message = "nombre invalido")
    private String nombre;

    private Integer cantidadMaximaAlumnos;







    public Curso() {
        this.alumnos = new ArrayList<>();
    }

    public Curso(DatosCurso datos){
        this.nombre = datos.getNombre();
        this.cantidadMaximaAlumnos = datos.getCantidadMaximaAlumnos();
        this.alumnos= new ArrayList<>();
    }

    public List<Alumno> agregarAlumno(Alumno alumno){
        this.alumnos.add(alumno);
        return alumnos;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadMaximaAlumnos() {
        return cantidadMaximaAlumnos;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void setCantidadMaximaAlumnos(Integer cantidadMaximaAlumnos) {
        this.cantidadMaximaAlumnos = cantidadMaximaAlumnos;
    }
}
