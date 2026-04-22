package com.ejemplo.productos.repository.impl;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.ProductoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {
    List<Producto> productos = new ArrayList<>();

    public ProductoRepositoryImpl() {
        productos.add(new Producto(1L, "TOMATES", 2.6, "Tomates de MUtxamel", new Categoria()));
    }

    @Override
    public List<Producto> findAll() {
        return List.of();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        for (Producto producto: productos){
            if (producto.getId().equals(id)){

            }
        }
    }

    @Override
    public Producto save(Producto p) {
        productos.add(p);
        return p;
    }

    @Override
    public void deleteById(Long id) {
        for (Producto producto: productos){
            if (producto.getId().equals(id)){

            }
        }
    }
}
