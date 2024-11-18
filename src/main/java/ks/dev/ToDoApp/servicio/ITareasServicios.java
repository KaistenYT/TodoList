package ks.dev.ToDoApp.servicio;

import java.util.List;

import ks.dev.ToDoApp.modelo.Tarea;

public interface ITareasServicios {

    public  List<Tarea> listaTareas();
    public Tarea buscarTarea(Integer idTareas);
    public void guardarTarea(Tarea  tarea);
    public void eliminarTarea(Tarea tarea);


}
