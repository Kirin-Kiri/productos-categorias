/*
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

    private List<Categoria> categorias;
    private Long id;

    public CategoriaRepositoryImpl() {
        this.categorias = new ArrayList<>();
        this.id = 0L;
    }

    @Override
    public List<Categoria> findAll() {
        return categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        categoria.setId(id++);
        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoria no puede estar vacia");
        } else {
            categorias.add(categoria);
            return categoria;
        }
    }

    @Override
    public void deleteById(Long id) {
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }
}
 */
