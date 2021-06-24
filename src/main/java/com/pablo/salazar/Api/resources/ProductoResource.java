package com.pablo.salazar.Api.resources;

import com.pablo.salazar.Api.controllers.ProductoController;
import com.pablo.salazar.Api.entities.Producto;
import com.pablo.salazar.Api.resources.Exceptions.CreateProductoException;
import com.pablo.salazar.Api.resources.Exceptions.EditProductoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ProductoResource.PRODUCTO)
public class ProductoResource {

    public static final String PRODUCTO = "/producto";
    public static final String ID = "/{id}";

    private ProductoController productoController;

    @Autowired
    public ProductoResource (ProductoController productoController){
        this.productoController = productoController;
    }

    @GetMapping
    public List<Producto> getAllProductos(@RequestParam(required = false) String brand) {
        if (brand == null) return this.productoController.findAllProducts();
        return this.productoController.findProductosByBrand(brand);
    }

    @GetMapping(value = ID)
    public ResponseEntity getProductoById(@PathVariable int id) {
        Optional<Producto> productoOptional = this.productoController.findProductoById(id);
        if (productoOptional.isPresent()) {
            return new ResponseEntity(productoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("\"El producto no existe\"", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity createProducto(@RequestBody Producto producto) throws CreateProductoException {
        try {
            this.productoController.createProducto(producto);
            return new ResponseEntity("\"El Producto fue creado\"", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new CreateProductoException("Los datos enviados no son los correctos");
        }
    }

    @PutMapping(value = ID)
    public ResponseEntity editProduct(@RequestBody Producto producto, @PathVariable int id) throws EditProductoException {
        try {
            if (this.productoController.editProductoById(id, producto))
                return new ResponseEntity("\"El producto fue editado\"", HttpStatus.ACCEPTED);
            return new ResponseEntity("\"El producto no  existe\"", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new EditProductoException("los datos enviados no son correctos");
        }
    }

    @DeleteMapping(value = ID)
    public  ResponseEntity deleteProducto(@PathVariable int id){
        if (this.productoController.deleteProductoById(id))
            return new ResponseEntity("\"El producto fue eliminado\"", HttpStatus.ACCEPTED);
        return new ResponseEntity("\"El producto no  existe\"", HttpStatus.NOT_FOUND);
    }
}
