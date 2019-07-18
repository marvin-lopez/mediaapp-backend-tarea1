package com.tarea1.controller;

import com.tarea1.model.Persona;
import com.tarea1.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public List<Persona> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Persona leerPorId(@PathVariable("id") Integer id){
        return service.leerPorId(id);
    }

    @PostMapping
    public void registrar(@RequestBody Persona obj){
        service.registrar(obj);
    }

    @PutMapping
    public void modificar(@RequestBody Persona obj){
        service.modificar(obj);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable("id") Integer id){ service.eliminar(id); }
}
