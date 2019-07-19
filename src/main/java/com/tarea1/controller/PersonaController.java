package com.tarea1.controller;

import com.tarea1.model.Persona;
import com.tarea1.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> listar(){
        List<Persona> lista = service.listar();
        return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> leerPorId(@PathVariable("id") Integer id){
        Persona obj=service.leerPorId(id);
        return new ResponseEntity<Persona>(obj,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Persona obj){
        Persona persona = service.registrar(obj);
        //localhost:8080/Personas/1
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(persona.getIdPersona()).toUri();

        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@Valid @RequestBody Persona obj){
        service.modificar(obj);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar (@PathVariable("id") Integer id){
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
