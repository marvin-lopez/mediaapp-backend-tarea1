package com.tarea1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@ApiModel(description = "Informacion de Persona")
@Entity
public class Producto {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @ApiModelProperty(notes="Nombre debe tener minimo 3 caracteres", example = "equipo", position = 1)
    @Size(min=3,message = "Nombre debe tener minimo 3 caracteres")
    @Column(name="nombre",nullable = false,length = 80)
    private String nombre;

    @ApiModelProperty(notes="marca debe tener minimo 3 caracteres", example ="IPHONE", position = 2)
    @Size(min=3,message = "marca debe tener minimo 3 caracteres")
    @Column(name="marca",nullable = false,length = 100)
    private String marca;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
