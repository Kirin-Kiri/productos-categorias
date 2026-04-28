package com.ejemplo.productos.repository.impl;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private List<Categoria> categorias = new ArrayList<>();
    private Long nextId = 1L;

    public CategoriaRepositoryImpl(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public List<Categoria> findAll() {
        return List.of();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId().equals(id)) {
                return Optional.of(categoria);
            }
        }

        return Optional.empty();
    }

    @Override
    public Categoria save(Categoria categoria) {

        if (categoria.getId() == null) {
            categoria.setId(nextId++);
        }

        categorias.add(categoria);

        return categoria;
    }

    @Override
    public void deleteById(Long id) {
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }
}
