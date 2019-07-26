package com.tarea1.Repository;

import com.tarea1.model.Persona;
import com.tarea1.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepo extends JpaRepository<Venta,Integer> {

}
