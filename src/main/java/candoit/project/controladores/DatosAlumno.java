package candoit.project.controladores;




import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DatosAlumno {


    private Integer dni;

    @NotNull
    @Size(min=3, message = "nombre invalido")
    private String nombre;

    @NotNull
    @Size(min=3, message = "apellido invalido")
    private String apellido;

    private Long idCurso;



    public DatosAlumno(){}

    public DatosAlumno(String nombre, String apellido, Integer dni, Long idCurso){

        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.idCurso = idCurso;

    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
