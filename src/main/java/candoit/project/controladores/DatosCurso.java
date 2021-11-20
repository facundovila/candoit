package candoit.project.controladores;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DatosCurso {

    @NotNull(message = "nombre invalido")
    @Size(min=3, message = "nombre invalido")
    private String nombre;

    private Integer cantidadMaximaAlumnos;

    public DatosCurso(){}
    public DatosCurso(String nombre, Integer cantidadMaximaAlumnos){
        this.nombre = nombre;
        this.cantidadMaximaAlumnos = cantidadMaximaAlumnos;
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

    public void setCantidadMaximaAlumnos(Integer cantidadMaximaAlumnos) {
        this.cantidadMaximaAlumnos = cantidadMaximaAlumnos;
    }
}
