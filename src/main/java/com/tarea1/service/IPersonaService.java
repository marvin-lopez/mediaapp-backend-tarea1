package com.tarea1.service;

import com.tarea1.model.Persona;
import java.util.List;


public interface IPersonaService  {

    void registrar(Persona obj);
    void modificar(Persona obj);
    List<Persona> listar();
    Persona leerPorId(Integer id);
    void eliminar(Integer id);

}
