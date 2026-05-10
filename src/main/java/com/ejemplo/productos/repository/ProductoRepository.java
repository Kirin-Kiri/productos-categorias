package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecioLessThan(double precio);
    List<Producto> findByPrecioGreaterThan(double precio);
    List<Producto> findByNombreIs(String nombre);
    List<Producto> findByNombreContaining(String nombre);
    List<Producto> findByNombreStartingWith(String nombre);
    List<Producto> findByNombreEndingWith(String nombre);
    List<Producto> findByCategoria_NombreIs(String categoria);
    List<Producto> findByCategoria_NombreIsAndPrecioLessThan(String categoria, double precio);
    List<Producto> findByCategoria_NombreIsAndNombreContaining(String categoria, String nombre);
    List<Producto> findByNombreContainingOrPrecioLessThan(String nombre, double precio);
    List<Producto> findByCategoria_NombreIsOrderByPrecioDesc(String categoria, double precio);
    List<Producto> findByPrecioBetween(double precio1, double precio2);
    List<Producto> findByCategoria_NombreIsAndPrecioGreaterThan(String categoria, double precio);
    List<Producto> findByOrderByPrecioAsc(double precio);


    /**
     public List<Producto> findAll();

     public Optional<Producto> findById(Long id);

     public Producto save(Producto p);

     public void deleteById(Long id);
     */
}
