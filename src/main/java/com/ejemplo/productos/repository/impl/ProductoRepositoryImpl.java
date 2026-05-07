/*
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
    private List<Producto> productos;
    private Long id;

    public ProductoRepositoryImpl() {
        this.productos = new ArrayList<>();
        this.id = 0L;
    }

    @Override
    public List<Producto> findAll() {
        return productos;
    }

    @Override
    public Optional<Producto> findById(Long id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return Optional.of(producto);
            }
        }
        return Optional.empty();
    }

    @Override
    public Producto save(Producto p) {

        p.setId(id++);
        if (p.getNombre() == null || p.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre producto no puede estar vacio");
        } else if (p.getCategoria() == null) {
            throw new IllegalArgumentException("La categoria no puede estar vacia");
        } else {
            productos.add(p);
            return p;
        }
    }

    @Override
    public void deleteById(Long id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                productos.remove(producto);
            }
        }
    }
}
 */
