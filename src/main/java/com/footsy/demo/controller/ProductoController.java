package com.footsy.demo.controller;



import com.footsy.demo.entity.ProductoEntity;
import com.footsy.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Optional;


@Controller
@RequestMapping(path = "/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //READ LISTAR TODOS LOS PRODUCTOS
    @GetMapping
    public String mostrarPaginaProductos(Model model) {
        model.addAttribute("productos",
                productoService.obtenerTodosLosProductos());
        return "index";
    }

    //LISTAR PRODUCTOS POR ID  //profe ListarProducto
    @GetMapping("/detalle/{id}")
    public String mostrarDetalleProducto(@PathVariable Integer id, Model model){
        ProductoEntity producto = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        model.addAttribute("producto", producto);
        return "producto/detalle";
    }

    // CREATE MOSTRAR FORMULARIO NUEVO PRODUCTO
    /*mostrar el formulario nuevo.html */
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoProducto(Model model) {
        model.addAttribute("producto", new ProductoEntity());
        return "producto/nuevo";
    }

    //CREATE GUARDAR PRODUCTO EN EL DB
    /* cuando envia el formulario de nuevo.html salva en la DB*/
    @PostMapping("/guardar")
    public String guardarProducto
    (@ModelAttribute ProductoEntity productoEntity, // la info del form
     @RequestParam("imagen") MultipartFile imagen) throws IOException { // la info de la imagen
      if (!imagen.isEmpty()) {
            String nombreArchivo = imagen.getOriginalFilename();
            Path ruta = Paths.get("src/main/resources/static/img/" + nombreArchivo);
            Files.copy(imagen.getInputStream(), ruta,
                    StandardCopyOption.REPLACE_EXISTING);
                    productoEntity.setUrlImagen(nombreArchivo);
       } else if (productoEntity.getId() != null) {
            ProductoEntity productoExistente = productoService
                    .obtenerProductoPorId(productoEntity.getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            productoEntity.setUrlImagen(productoExistente.getUrlImagen());
        }
        productoService.guardarProducto(productoEntity);
        return "redirect:/productos";
    }

    //UPDATE EDITAR PRODUCTO POR ID
    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Integer id, Model model) {
        ProductoEntity producto = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        model.addAttribute("producto", producto);
        return "producto/nuevo";
    }

    //DELETE ELIMINA PRODUCTO DEL DATABASE
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }


}