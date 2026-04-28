package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.service.CategoriaService;
import com.ejemplo.productos.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("productos")
public class ProductoController {
    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "productos";
    }

    @PostMapping
    public String guardar(Producto producto) throws Exception {
        Optional<Categoria> categoria = categoriaService.obtenerPorId(producto.getCategoria().getId());
        if (categoria.isPresent()){
            producto.setCategoria(categoria.get());
            productoService.guardarProducto(producto);
        } else {
            throw new Exception("La categoria no existe en la aplicacion");
        }
        return "redirect:/productos";
    }
}
