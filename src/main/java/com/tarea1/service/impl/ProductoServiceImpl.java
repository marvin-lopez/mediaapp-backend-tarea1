package com.tarea1.service.impl;

import com.tarea1.Repository.IProductoRepo;
import com.tarea1.model.Producto;
import com.tarea1.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepo repo;

    @Override
    public Producto registrar(Producto obj) {
       return  repo.save(obj);
    }

    @Override
    public Producto modificar(Producto obj) {
       return repo.save(obj);
    }

    @Override
    public List<Producto> listar() {
        return repo.findAll();
    }

    @Override
    public Producto leerPorId(Integer id) {
        return repo.findOne(id);
    }

    @Override
    public void eliminar(Integer id) {
             repo.delete(id);
    }
}
