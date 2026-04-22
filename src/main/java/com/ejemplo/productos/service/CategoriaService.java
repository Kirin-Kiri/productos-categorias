package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.impl.CategoriaRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepositoryImpl categoriaService;

    public CategoriaService(CategoriaRepositoryImpl categoriaService) {
        this.categoriaService = categoriaService;
    }

    public List<Categoria> listarCategorias(){
        return categoriaService.findAll();
    }

    public Optional<Categoria> obtenerPorId(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoriaService.findById(id);
    }

    public void guardarCategoria(Categoria categoria){
        categoriaService.save(categoria);
    }

    public void actualizarCategoria(Categoria categoria){
        //TODO falta implementar la actualizacion en el repo
    }

    public void eliminarCategoria(Long id){
        categoriaService.deleteById(id);
    }
}
