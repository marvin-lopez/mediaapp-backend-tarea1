package com.tarea1.service.impl;

import com.tarea1.Repository.IPersonaRepo;
import com.tarea1.Repository.IVentaRepo;
import com.tarea1.model.Persona;
import com.tarea1.model.Venta;
import com.tarea1.service.IPersonaService;
import com.tarea1.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private IVentaRepo repo;

    @Autowired
    private IPersonaService personaService;

    @Override
    public Venta registrar(Venta obj) {
        obj.getDetalleVenta().forEach(det ->{
            det.setVenta(obj);
        });

        return  repo.save(obj);
    }

    @Override
    public Venta modificar(Venta obj) {
        return repo.save(obj);
    }

    @Override
    public List<Venta> listar() {
        return repo.findAll();
    }

    @Override
    public Venta leerPorId(Integer id) {
        return repo.findOne(id);
    }

    @Override
    public void eliminar(Integer id) {
        repo.delete(id);
    }
}
