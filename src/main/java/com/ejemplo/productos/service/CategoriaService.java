package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obtenerPorId(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoriaRepository.findById(id);
    }

    public void guardarCategoria(Categoria categoria) {
        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        } else {
            categoria.setNombre(categoria.getNombre().toUpperCase());
            categoriaRepository.save(categoria);
        }
    }

    public void actualizarCategoria(Categoria categoria) {
        //TODO falta implementar la actualizacion en el repo
    }

    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
