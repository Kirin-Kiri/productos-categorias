package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.impl.ProductoRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class ProductoService {
    private final ProductoRepositoryImpl productoRepository;

    public ProductoService(ProductoRepositoryImpl productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }

    public void guardarProducto(Producto p){
        if(p.getNombre() == null || p.getNombre().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede ser nulo")
        } else {
            p.setNombre(p.getNombre().toUpperCase());
            if (p.getCategoria() == null){

            }
        }

        productoRepository.save(p);
    }

    public void actualizarProducto(Producto p){
        //TODO falta implementar la actualizacion en el repo
    }

    public void eliminarProducto(Long id){
        productoRepository.deleteById(id);
    }
}
