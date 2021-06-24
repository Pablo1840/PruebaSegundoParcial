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

    public Optional<Producto> findProductById(int id) {
        return this.productoRepository.findById(id);
    }

    public List<Producto> findProductosByMarca(String brand) {
        return this.productoRepository.findProductosByBrand(brand);
    }

}
