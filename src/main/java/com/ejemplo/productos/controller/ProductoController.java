package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.service.CategoriaService;
import com.ejemplo.productos.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "productos";
    }

    @PostMapping
    public String guardar(Producto producto) throws Exception {
        Optional<Categoria> categoria = categoriaService.obtenerPorId(producto.getCategoria().getId());
        if (categoria.isPresent()) {
            producto.setCategoria(categoria.get());
            productoService.guardarProducto(producto);
        } else {
            throw new Exception("La categoria no existe en la aplicacion");
        }
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }

    @GetMapping("/ejecutar/{parametro}/{filtro1}/{filtro2}")
    public String ejecutar(@PathVariable("parametro") String parametro, @PathVariable("filtro1") String filtro1, @PathVariable("filtro2") String filtro2, Model model) {
        //Debemos de rellenar productos y categorías para que no de error la página
        model.addAttribute("productos", productoService.listarProductos());
        model.addAttribute("categorias", categoriaService.listarCategoria());
        //Almcenaremos en la variable "resultado" el resultado de la consulta y lo mostraremos en el HTML
        if (parametro.equals("buscarProductosPrecioMenorQue")) {
            model.addAttribute("resultado", productoService.obtenerProductosPrecioMenor(Double.parseDouble(filtro1)));
        } else if (parametro.equals("buscarProductosPrecioMayorQue")) {
            model.addAttribute("resultado", productoService.buscarProductosPrecioMayorQue(Double.parseDouble(filtro1)));
        } else if (parametro.equals("buscarProducto")) {
            model.addAttribute("resultado", productoService.buscarProducto(filtro1));
        } else if (parametro.equals("buscarProductosContienePortatil")) {
            model.addAttribute("resultado", productoService.buscarProductosContienePortatil(filtro1));
        } else if (parametro.equals("buscarProductosEmpiezaDisco")) {
            model.addAttribute("resultado", productoService.buscarProductosEmpiezaDisco(filtro1));
        } else if (parametro.equals("buscarProductoTerminen")) {
            model.addAttribute("resultado", productoService.buscarProductoTerminen(filtro1));
        } else if (parametro.equals("buscarProductosComponentes")) {
            model.addAttribute("resultado", productoService.buscarProductosComponentes(filtro1));
        } else if (parametro.equals("buscarPerifericosMenor100")) {
            model.addAttribute("resultado", productoService.buscarPerifericosMenor100((filtro1),Double.parseDouble(filtro2)));
        } else if (parametro.equals("buscarAlmacenamientoDisco")) {
            model.addAttribute("resultado", productoService.buscarAlmacenamientoDisco((filtro1),(filtro2)));
        } else if (parametro.equals("buscarRedesMenor100")) {
            model.addAttribute("resultado", productoService.buscarRedesMenor100((filtro1),Double.parseDouble(filtro2)));
        } else if (parametro.equals("buscarSSDPrecioMenor30")) {
            model.addAttribute("resultado", productoService.buscarSSDPrecioMenor30((filtro1),Double.parseDouble(filtro2)));
        } else if (parametro.equals("productosOrdenadosPrecioAsc")) {
            model.addAttribute("resultado", productoService.productosOrdenadosPrecioAsc(Double.parseDouble(filtro1)));
        } else if (parametro.equals("portatilesOrdenadosPrecioDesc")) {
            model.addAttribute("resultado", productoService.portatilesOrdenadosPrecioDesc((filtro1),Double.parseDouble(filtro2)));
        } else if (parametro.equals("productosEntre50y200")) {
            model.addAttribute("resultado", productoService.productosEntre50y200(Double.parseDouble(filtro1),Double.parseDouble(filtro2)));
        } else if (parametro.equals("componentesMayor100")) {
            model.addAttribute("resultado", productoService.componentesMayor100((filtro1),Double.parseDouble(filtro2)));
        }



        //TODO añade el resto de métodos siguiendo la estructura del if-else-if
        return "productos";
    }
}
