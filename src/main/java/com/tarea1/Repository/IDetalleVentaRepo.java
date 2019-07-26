package com.tarea1.Repository;

import com.tarea1.model.DetalleVenta;
import com.tarea1.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleVentaRepo extends JpaRepository<DetalleVenta,Integer> {

}
