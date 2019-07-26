package com.tarea1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_venta", nullable = false,foreignKey = @ForeignKey(name = "fk_detalle_venta_venta"))
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_producto",nullable = false,foreignKey = @ForeignKey(name="fk_detalle_venta_productos"))
    private Producto producto;


    @Min(value=1)
    @Column(name="cantidad",nullable = false)
    private Integer cantidad;

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
