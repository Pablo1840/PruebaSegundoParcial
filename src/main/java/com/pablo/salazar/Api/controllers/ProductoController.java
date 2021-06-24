package com.pablo.salazar.Api.controllers;

import com.pablo.salazar.Api.entities.Producto;
import com.pablo.salazar.Api.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    private ProductoRepository productoRepository;

    @Autowired
    public ProductoController(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Producto> findAllProducts() {
        return this.productoRepository.findAll();
    }

    public Optional<Producto> findProductoById(int id) {
        return this.productoRepository.findById(id);
    }

    public List<Producto> findProductosByBrand(String brand) {
        return this.productoRepository.findProductosByBrand(brand);
    }

    public void createProducto(Producto producto) {
        this.productoRepository.save(producto);
    }

    public boolean editProductoById(int id, Producto producto) {
        Optional<Producto> productoOptional = this.findProductoById(id);
        if (!productoOptional.isPresent()) return false;
        Producto productodb = productoOptional.get();
        productodb.setBrand(producto.getBrand());
        productodb.setModel(producto.getModel());
        productodb.setPrice(producto.getPrice());
        productoRepository.save(productodb);
        return true;
    }

    public boolean deleteProductoById(int id) {
        Optional<Producto> productoOptional = this.findProductoById(id);
        if (!productoOptional.isPresent()) return false;
        productoRepository.deleteById(id);
        return true;
    }

}
