package com.tarea1.service.impl;

import com.tarea1.Repository.IDetalleVentaRepo;
import com.tarea1.model.DetalleVenta;
import com.tarea1.service.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

    @Autowired
    private IDetalleVentaRepo repo;

    @Override
    public DetalleVenta registrar(DetalleVenta obj) {
        return  repo.save(obj);
    }

    @Override
    public DetalleVenta modificar(DetalleVenta obj) {
        return repo.save(obj);
    }

    @Override
    public List<DetalleVenta> listar() {
        return repo.findAll();
    }

    @Override
    public DetalleVenta leerPorId(Integer id) {
        return repo.findOne(id);
    }

    @Override
    public void eliminar(Integer id) {
        repo.delete(id);
    }
}
