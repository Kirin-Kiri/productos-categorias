package com.ejemplo.productos.repository.impl;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {
    @Override
    public List<Categoria> findAll() {
        return List.of();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        for (Categoria categoria: categorias) {
            if (categoria.getId() == id){
                return new Optional
            }
        }
    }

    @Override
    public Categoria save(Categoria categoria) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        for (Categoria categoria: categorias) {
            if (categoria.getId().equals(id)){
                return Optional.of(categoria);
            }
        }
    }
}
