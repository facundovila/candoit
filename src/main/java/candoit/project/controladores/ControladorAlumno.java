package candoit.project.controladores;


import candoit.project.modelo.Alumno;
import candoit.project.modelo.Curso;
import candoit.project.servicios.ServicioAlumno;
import candoit.project.servicios.ServicioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
public class ControladorAlumno {

    private ServicioAlumno servicioAlumno;
    private ServicioCurso servicioCurso;


    @Autowired
    public ControladorAlumno(ServicioAlumno servicioAlumno, ServicioCurso servicioCurso){
        this.servicioAlumno = servicioAlumno;
        this.servicioCurso = servicioCurso;
    }

    @RequestMapping(path= "/crear-alumno", method = RequestMethod.GET)
    public ModelAndView crearAlumno(){

        ModelMap modelo= new ModelMap();
        List<Curso> curso = servicioCurso.listarTodas();
        modelo.put("datosAlumnos", new DatosAlumno());
        modelo.put("cursos", curso);

        return new ModelAndView("crearAlumno", modelo);

    }

    @RequestMapping(path = "/guardar-alumno", method = RequestMethod.POST)
    public ModelAndView crearAlumno(@Valid @ModelAttribute("datosAlumnos") DatosAlumno datosAlumno, BindingResult resultadoValidacion) {

        ModelMap modelo = new ModelMap();

        if (resultadoValidacion.hasErrors()) {
            return new ModelAndView("redirect:/crear-alumno", resultadoValidacion.getModel());
        }

        servicioAlumno.guardar(datosAlumno);
        modelo.put("datosAlumnos", "Se guardo correctamente los datos del alumno");
        return new ModelAndView("redirect:/mostrar-alumnos");


    }

    @RequestMapping(path = "/mostrar-alumnos")
    public ModelAndView MostrarAlumnos () {

        ModelMap modelo = new ModelMap();
        List<Alumno> alumnos  = servicioAlumno.listarAlumnos();
        modelo.put("listaAlumnos", alumnos);

        return new ModelAndView("listaAlumno", modelo);
    }



}
