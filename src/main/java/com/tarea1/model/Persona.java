package com.tarea1.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.persistence.*;
import javax.validation.constraints.Size;

@ApiModel(description = "Informacion de Persona")
@Entity
@Table(name="persona")
public class Persona {


    @ApiParam(hidden=true)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPersona;

    @ApiModelProperty(notes="Nombres debe tener minimo 3 caracteres", example = "marvin", position = 1)
    @Size(min=3,message = "Nombres debe tener minimo 3 caracteres")
    @Column(name="nombres",nullable = false,length = 70)
    private String nombres;

    @ApiModelProperty(notes="Apellidos debe tener minimo 3 caracteres", example ="lopez", position = 2)
    @Size(min=3,message = "Apellidos debe tener minimo 3 caracteres")
    @Column(name="apellidos",nullable = false,length = 70)
    private String apellidos;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
