package com.tarea1.controller;

import com.tarea1.exception.ModelNotFoundException;
import com.tarea1.model.Venta;
import com.tarea1.service.IVentaService;
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
@RequestMapping(value = "/Ventas")
@Api(value = "CRUD para crear, recuperar, actualizar y eliminar Ventas")
public class VentaController {

    @Autowired
    private IVentaService service;


    @PostMapping
    @ApiOperation("Crea nueva Venta.")
    public ResponseEntity<Object> registrar(@Valid @RequestBody Venta obj){
        Venta Venta = service.registrar(obj);
        //localhost:8080/Ventas/1
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Venta.getIdVenta()).toUri();
        return ResponseEntity.created(location).build();
    }


}
