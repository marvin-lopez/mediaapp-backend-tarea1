package com.tarea1.controller;

import com.tarea1.exception.ModelNotFoundException;
import com.tarea1.model.Persona;
import com.tarea1.service.IPersonaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/personas")
@Api(value = "CRUD para crear, recuperar, actualizar y eliminar personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    @ApiOperation("Retorna el listado de todas las personas.")
    public ResponseEntity<List<Persona>> listar(){
        List<Persona> lista = service.listar();
        return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Devuelve una persona específica por su identificador. 404 si no existe.")
    public ResponseEntity<Persona> leerPorId(@PathVariable("id") Integer id){
        Persona obj=service.leerPorId(id);
        if(obj==null){
            throw new ModelNotFoundException("ID NO ENCONTRADO: "+ id);
        }
        return new ResponseEntity<Persona>(obj,HttpStatus.OK);
    }

    @GetMapping("/hateoas/{id}")
    @ApiOperation("Devuelve una persona específica por su identificador. 404 si no existe.")
    public Resource<Persona> leerPorIdHateoas(@PathVariable("id") Integer id){
        Persona obj=service.leerPorId(id);
        if(obj==null){
            throw new ModelNotFoundException("ID NO ENCONTRADO: "+ id);
        }

        Resource<Persona> resource = new Resource<Persona>(obj);
        //localhost:8080/personas/{id}
        ControllerLinkBuilder linkTo=  linkTo(methodOn(this.getClass()).leerPorId(id));
        resource.add(linkTo.withRel("persona-resource"));
        return resource;

    }

    @PostMapping
    @ApiOperation("Crea nueva persona.")
    public ResponseEntity<Object> registrar(@Valid @RequestBody Persona obj){
        Persona persona = service.registrar(obj);
        //localhost:8080/Personas/1
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(persona.getIdPersona()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    @ApiOperation("Modifica a una persona por su identificador")
    public ResponseEntity<Object> modificar(@Valid @RequestBody Persona obj){
        service.modificar(obj);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Borra a una persona del sistema. 404 si no se encuentra el identificador de la persona.")
    public ResponseEntity<Object> eliminar (@PathVariable("id") Integer id){
        Persona obj=service.leerPorId(id);
        if(obj==null){
            throw new ModelNotFoundException("ID NO ENCONTRADO: "+ id);
        }else{
            service.eliminar(id);
        }

        return new ResponseEntity<Object>(obj,HttpStatus.OK);
    }
}
