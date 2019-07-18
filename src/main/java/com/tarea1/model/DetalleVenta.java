package com.tarea1.model;

public class DetalleVenta {

    private Integer idDetalleVenta;
    private Venta idVenta;
    private Producto idPRoducto;
    private Integer cantidad;

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    public Producto getIdPRoducto() {
        return idPRoducto;
    }

    public void setIdPRoducto(Producto idPRoducto) {
        this.idPRoducto = idPRoducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
