package com.sebasdiaz.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //Decorador para entidades
public class Producto {

    @Id //clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID autoincrementable
    private Long id;
    private String nombre;

    //Get and Set
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    private double precio;

    
}
