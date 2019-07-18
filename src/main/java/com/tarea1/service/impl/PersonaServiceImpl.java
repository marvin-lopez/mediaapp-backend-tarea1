package com.tarea1.service.impl;

import com.tarea1.model.Persona;
import com.tarea1.Repository.IPersonaRepo;
import com.tarea1.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaRepo repo;

    @Override
    public void registrar(Persona obj) {
        repo.save(obj);
    }

    @Override
    public void modificar(Persona obj) {
       repo.save(obj);
    }

    @Override
    public List<Persona> listar() {
        return repo.findAll();
    }

    @Override
    public Persona leerPorId(Integer id) {
        return repo.findOne(id);
    }

    @Override
    public void eliminar(Integer id) {
             repo.delete(id);
    }
}
