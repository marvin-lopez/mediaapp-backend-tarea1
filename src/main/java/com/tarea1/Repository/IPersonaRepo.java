package com.tarea1.Repository;

import com.tarea1.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepo  extends JpaRepository<Persona,Integer> {

}
