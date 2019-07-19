package com.tarea1.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPersona;

    @Size(min=3,message = "Nombres debe tener minimo 3 caracteres")
    @Column(name="nombres",nullable = false,length = 70)
    private String nombres;

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
