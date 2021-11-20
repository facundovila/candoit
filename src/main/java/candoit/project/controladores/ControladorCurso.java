package candoit.project.controladores;


import candoit.project.modelo.Curso;
import candoit.project.servicios.CampoVacioException;
import candoit.project.servicios.ServicioCurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ControladorCurso {

    private ServicioCurso servicioCurso;


    @Autowired
    public ControladorCurso(ServicioCurso servicioCurso){

        this.servicioCurso = servicioCurso;
    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {
        return new ModelAndView("redirect:/crear-curso");
    }


    @RequestMapping(path= "/crear-curso", method = RequestMethod.GET)
    public ModelAndView crearCurso(){
        ModelMap modelo = new ModelMap();
        modelo.put("datosCurso", new DatosCurso());
        return new ModelAndView("home", modelo);
    }

    @RequestMapping(path = "/guardar-curso", method = RequestMethod.POST)
    public ModelAndView crearCurso(@Valid @ModelAttribute ("datosCurso") DatosCurso datos, BindingResult resultValidacion){
        ModelMap modelo = new ModelMap();

            if(resultValidacion.hasErrors()){
                return new ModelAndView("redirect:/crear-curso",resultValidacion.getModel()); }

            servicioCurso.guardar(datos);

            modelo.put("datosCurso","se creo el curso correctamente");

         return new ModelAndView("redirect:/mostrar-cursos");


    }


    @RequestMapping(path = "/mostrar-cursos")
    public ModelAndView MostrarCursos () {

        ModelMap modelo = new ModelMap();
        List<Curso> cursos  = servicioCurso.listarTodas();
        modelo.put("listaCursos", cursos);

        return new ModelAndView("listaCurso", modelo);
    }

    @RequestMapping(path = "/detalle-curso", method = RequestMethod.GET)
        public ModelAndView listarParaBorrar(@RequestParam("idCurso") Long idCurso){

        ModelMap modelo = new ModelMap();
        final var cursos =servicioCurso.getById(idCurso);
        modelo.put("datosCurso",cursos);

        return new ModelAndView("detalleDeCurso", modelo);
    }

    @RequestMapping(path = "/borrar-alumno", method = RequestMethod.GET)
    public ModelAndView borrarAlumno(@RequestParam("idCurso") Long idCurso, @RequestParam("idAlumno") Long idAlumno){

        ModelMap modelo = new ModelMap();
        servicioCurso.eliminarAlumno(idCurso,idAlumno);

        final var curso = servicioCurso.getById(idCurso);

        modelo.put("datosCurso", curso);

        return new ModelAndView("detalleDeCurso", modelo);
    }
}
