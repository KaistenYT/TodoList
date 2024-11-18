package ks.dev.ToDoApp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ks.dev.ToDoApp.modelo.Tarea;
@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Integer> {

}
