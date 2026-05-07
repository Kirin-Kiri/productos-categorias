package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    /**
     public List<Categoria> findAll();

     public Optional<Categoria> findById(Long id);

     public Categoria save(Categoria categoria);

     public void deleteById(Long id);
     */
}

