package com.pablo.salazar.Api.repositories;

import com.pablo.salazar.Api.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Integer>{
    List<Producto> findProductosByBrand(String brand);
}
