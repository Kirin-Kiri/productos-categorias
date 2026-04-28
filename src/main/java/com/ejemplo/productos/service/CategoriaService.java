package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.impl.CategoriaRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepositoryImpl categoriaRepository;

    public CategoriaService(CategoriaRepositoryImpl categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obtenerPorId(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoriaRepository.findById(id);
    }

    public void guardarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public void actualizarCategoria(Categoria categoria){
        //TODO falta implementar la actualizacion en el repo
    }

    public void eliminarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
