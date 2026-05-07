package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.ProductoRepository;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        Optional<Producto> categoria = productoRepository.findById(id);
        return productoRepository.findById(id);
    }

    public void guardarProducto(Producto p) {
        if (p.getNombre() == null || p.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        } else {
            p.setNombre(p.getNombre().toUpperCase());
            if (p.getCategoria() == null) {
                throw new IllegalArgumentException("La categoria no puede ser nulo");
            } else {
                productoRepository.save(p);
            }
        }
    }

    public void actualizarProducto(Producto p) {
        //TODO falta implementar la actualizacion en el repo
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    public @Nullable List<Producto> obtenerProductosPrecioMenor(double precio){
        if (precio != 0.0){
            return productoRepository.findByPrecioLessThan(precio);
        } else {
            throw new IllegalArgumentException("El precio no puede estar a 0");
        }
    }
}
