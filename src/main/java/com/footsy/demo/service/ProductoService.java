package com.footsy.demo.service;
import java.util.Optional;
import com.footsy.demo.entity.ProductoEntity;
import com.footsy.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    /*Crear un nuevo producto*/
    public ProductoEntity guardarProducto(ProductoEntity productoEntity) {
        return productoRepository.save(productoEntity);
    }

    /*ObtenerTodosLosProductos*/
    public List<ProductoEntity> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    /*ObtenerProductoId*/
    public Optional<ProductoEntity> obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id);
    }
    
    /*actualizar producto*/  //este metodo no fue usado en productoController
    public ProductoEntity actualizarProducto(Integer id, ProductoEntity productoActualizado) {
        Optional<ProductoEntity> productoExistente = productoRepository.findById(id);
        if (productoExistente.isPresent()) {
            productoActualizado.setId(id);
            return productoRepository.save(productoActualizado);
        }
        return null;
    }
        /*Delete*/
    public boolean eliminarProducto(Integer id) {
        Optional<ProductoEntity> productoEntity = productoRepository.findById(id);
        if (productoEntity.isPresent()) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
