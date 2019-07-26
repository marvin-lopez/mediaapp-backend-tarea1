package com.tarea1.controller;

import com.tarea1.model.DetalleVenta;
import com.tarea1.service.IDetalleVentaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping(value = "/DetalleVentas")
@Api(value = "CRUD para crear, recuperar, actualizar y eliminar DetalleVentas")
public class DetalleVentaController {

    @Autowired
    private IDetalleVentaService service;


    @PostMapping
    @ApiOperation("Crea nueva DetalleVenta.")
    public ResponseEntity<Object> registrar(@Valid @RequestBody DetalleVenta obj){
        DetalleVenta DetalleVenta = service.registrar(obj);
        //localhost:8080/DetalleVentas/1
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(DetalleVenta.getIdDetalleVenta()).toUri();
        return ResponseEntity.created(location).build();
    }


}
