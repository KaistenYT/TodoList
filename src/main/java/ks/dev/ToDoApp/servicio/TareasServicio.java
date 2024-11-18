package ks.dev.ToDoApp.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ks.dev.ToDoApp.modelo.Tarea;
import ks.dev.ToDoApp.repositorio.TareaRepositorio;

@Service

public class TareasServicio implements  ITareasServicios {
    @Autowired  
    private  TareaRepositorio tareaRepositorio;

    @Override
    public List<Tarea> listaTareas() {
    return tareaRepositorio.findAll();
    }

    @Override
    public Tarea buscarTarea(Integer idTareas) {
        return  tareaRepositorio.findById(idTareas).orElse(null);
      
    }

    @Override
    public void guardarTarea(Tarea tarea) {
       tareaRepositorio.save(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
      tareaRepositorio.delete(tarea);
    }




}
