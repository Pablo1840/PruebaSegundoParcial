package com.pablo.salazar.Api.entities;

import javax.persistence.*;

import java.util.Objects;

@Entity(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String brand,model;
    private double price;

    public Producto(int id, String brand, String model, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Producto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && Double.compare(producto.price, price) == 0 && Objects.equals(brand, producto.brand) && Objects.equals(model, producto.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}