package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {

    public List<Producto> findAll();

    public Optional<Producto> findById(Long id);

    public Producto save(Producto p);

    public void deleteById(Long id);
}
