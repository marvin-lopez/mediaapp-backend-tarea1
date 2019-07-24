package com.tarea1.Repository;

import com.tarea1.model.Persona;
import com.tarea1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepo extends JpaRepository<Producto,Integer> {

}
