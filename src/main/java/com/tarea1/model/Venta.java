package com.tarea1.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    //ISO Date yyyy-mm-ddTHH:mm:ss.mmm
    @JsonSerialize(using= ToStringSerializer.class)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name="id_persona",nullable = false,foreignKey = @ForeignKey(name="fk_venta_persona") )
    private Persona persona;

    private double importe;

    @OneToMany(mappedBy = "venta",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},
            fetch =FetchType.LAZY,orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public List<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
}
