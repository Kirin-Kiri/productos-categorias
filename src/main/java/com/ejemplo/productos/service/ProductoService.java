package com.ejemplo.productos.service;

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

    public @Nullable List<Producto> obtenerProductosPrecioMenor(double precio) {
        if (precio != 0.0) {
            return productoRepository.findByPrecioLessThan(precio);
        } else {
            throw new IllegalArgumentException("El precio no puede estar a 0");
        }
    }

    public @Nullable List<Producto> buscarProductosPrecioMayorQue(double precio) {
        return productoRepository.findByPrecioGreaterThan(precio);
    }

    public @Nullable List<Producto> buscarProducto(String nombre) {
        return productoRepository.findByNombreIs(nombre);
    }

    public @Nullable List<Producto> buscarProductosContienePortatil(String nombre) {
        return productoRepository.findByNombreContaining(nombre);
    }


    public @Nullable List<Producto> buscarProductosEmpiezaDisco(String nombre) {
        return productoRepository.findByNombreStartingWith(nombre.toUpperCase());
    }

    public @Nullable List<Producto> buscarProductoTerminen(String nombre) {
        return productoRepository.findByNombreEndingWith(nombre.toUpperCase());
    }

    public @Nullable List<Producto> buscarProductosComponentes(String categoria) {
        return productoRepository.findByCategoria_NombreIs(categoria);
    }

    public @Nullable List<Producto> buscarPerifericosMenor100(String categoria, double precio) {
        return productoRepository.findByCategoria_NombreIsAndPrecioLessThan(categoria, precio);
    }

    public @Nullable List<Producto> buscarAlmacenamientoDisco(String categoria, String nombre) {
        return productoRepository.findByCategoria_NombreIsAndNombreContaining(categoria, nombre);
    }

    public @Nullable List<Producto> buscarRedesMenor100(String categoria, double precio) {
        return productoRepository.findByCategoria_NombreIsAndPrecioLessThan(categoria, precio);
    }

    public @Nullable List<Producto> buscarSSDPrecioMenor30(String nombre, double precio) {
        return productoRepository.findByNombreContainingOrPrecioLessThan(nombre, precio);
    }

    public @Nullable List<Producto> productosOrdenadosPrecioAsc(double precio) {
        return productoRepository.findByOrderByPrecioAsc(precio);
    }

    public @Nullable List<Producto> portatilesOrdenadosPrecioDesc(String categoria, double precio) {
        return productoRepository.findByCategoria_NombreIsOrderByPrecioDesc(categoria, precio);
    }

    public @Nullable List<Producto> productosEntre50y200(double precio1, double precio2) {
        return productoRepository.findByPrecioBetween(precio1, precio2);
    }

    public @Nullable List<Producto> componentesMayor100(String categoria, double precio) {
        return productoRepository.findByCategoria_NombreIsAndPrecioGreaterThan(categoria, precio);
    }
}
