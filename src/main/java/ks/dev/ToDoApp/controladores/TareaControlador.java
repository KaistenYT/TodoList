package ks.dev.ToDoApp.controladores;

import ks.dev.ToDoApp.modelo.Tarea;
import ks.dev.ToDoApp.servicio.TareasServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TareaControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(TareaControlador.class);

    @Autowired
    TareasServicio tareasServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<Tarea> tareas = tareasServicio.listaTareas();
        tareas.forEach(tarea -> logger.info(tarea.toString()));
        modelo.put("tareas", tareas);
        return "index";
    }
@GetMapping("/agregar")
    public  String mostrarAgregar(){
        return "agregar";
}

@PostMapping ("/agregar")
        public String agregar(@ModelAttribute ("tareaForma")Tarea tarea){

        logger.info("Tarea a agregar: " + tarea);
        tareasServicio.guardarTarea(tarea);
        return "redirect:/";
}

@GetMapping("/editar/{id}")

    public String mostrarEditar(@PathVariable(value = "id")int idTarea, ModelMap modelo){
     Tarea tarea = tareasServicio.buscarTarea(idTarea);
     modelo.put("tarea", tarea);
     return "editar";
}
@PostMapping("/editar")
    public String editar(@ModelAttribute("tarea")Tarea tarea){
        logger.info("Tarea a guardar" + tarea);
        tareasServicio.guardarTarea(tarea);
        return "redirect:/";

}

@GetMapping("/eliminar/{id}")
    public String eliminar (@PathVariable(value = "id")int idTarea, ModelMap modelo){
        Tarea tarea = new Tarea();
        tarea.setIdTarea(idTarea);
        tareasServicio.eliminarTarea(tarea);
        return "redirect:/";
}
    

}
