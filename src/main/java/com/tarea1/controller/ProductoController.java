package com.tarea1.controller;

import com.tarea1.exception.ModelNotFoundException;
import com.tarea1.model.Producto;
import com.tarea1.service.IProductoService;
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

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/Productos")
@Api(value = "CRUD para crear, recuperar, actualizar y eliminar Productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping
    @ApiOperation("Retorna el listado de todas las Productos.")
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> lista = service.listar();
        return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Devuelve una Producto específica por su identificador. 404 si no existe.")
    public ResponseEntity<Producto> leerPorId(@PathVariable("id") Integer id){
        Producto obj=service.leerPorId(id);
        if(obj==null){
            throw new ModelNotFoundException("ID NO ENCONTRADO: "+ id);
        }
        return new ResponseEntity<Producto>(obj,HttpStatus.OK);
    }

    @GetMapping("/hateoas/{id}")
    @ApiOperation("Devuelve una Producto específica por su identificador. 404 si no existe.")
    public Resource<Producto> leerPorIdHateoas(@PathVariable("id") Integer id){
        Producto obj=service.leerPorId(id);
        if(obj==null){
            throw new ModelNotFoundException("ID NO ENCONTRADO: "+ id);
        }

        Resource<Producto> resource = new Resource<Producto>(obj);
        //localhost:8080/Productos/{id}
        ControllerLinkBuilder linkTo=  linkTo(methodOn(this.getClass()).leerPorId(id));
        resource.add(linkTo.withRel("Producto-resource"));
        return resource;

    }

    @PostMapping
    @ApiOperation("Crea nueva Producto.")
    public ResponseEntity<Object> registrar(@Valid @RequestBody Producto obj){
        Producto Producto = service.registrar(obj);
        //localhost:8080/Productos/1
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Producto.getIdProducto()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    @ApiOperation("Modifica a una Producto por su identificador")
    public ResponseEntity<Object> modificar(@Valid @RequestBody Producto obj){
        service.modificar(obj);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Borra a una Producto del sistema. 404 si no se encuentra el identificador de la Producto.")
    public ResponseEntity<Object> eliminar (@PathVariable("id") Integer id){
        Producto obj=service.leerPorId(id);
        if(obj==null){
            throw new ModelNotFoundException("ID NO ENCONTRADO: "+ id);
        }else{
            service.eliminar(id);
        }

        return new ResponseEntity<Object>(obj,HttpStatus.OK);
    }
}
