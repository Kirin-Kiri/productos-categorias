package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecioLessThan(double precio);
    List<Producto> findByPrecioGreaterThan(double precio);
    /**
     public List<Producto> findAll();

     public Optional<Producto> findById(Long id);

     public Producto save(Producto p);

     public void deleteById(Long id);
     */
}
