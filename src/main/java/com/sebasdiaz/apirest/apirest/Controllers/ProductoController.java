package com.sebasdiaz.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebasdiaz.apirest.apirest.Repositories.ProductoRepository;
import com.sebasdiaz.apirest.apirest.Entities.Producto;

@RestController // Decorador de CRUD
@RequestMapping("/productos")
public class ProductoController { //Se encarga de controlar todas las peticiones

    @Autowired
    private ProductoRepository productoRepository; // Instaciacion del repositorio

    @GetMapping // Traer informacion de todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}") // Traer informacion de producto por ID
    public Producto getProductById(@PathVariable Long id){
        return productoRepository.findById(id) //Retorna el producto con el ID
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " + id )); //Devuelve error en caso de no encontrar el ID
    }

    @PostMapping //Agregar producto
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto); //Grava y devuelve el producto
    }

    @PutMapping("/{id}") //Actualiza (modifica) un producto
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detailsProducto){

         Producto producto = productoRepository.findById(id) //Asigna en una variable el producto que del request
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " + id )); //Devuelve error en caso de no encontrar el ID
        
        producto.setNombre(detailsProducto.getNombre()); //Setea(Modifica) el producto
        producto.setPrecio(detailsProducto.getPrecio()); //Setea(Modifica) el producto

        return productoRepository.save(producto); // Guarda y devuelve el producto al repositorio con las modificaciones (Actualiza la base de datos).
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        Producto producto = productoRepository.findById(id) //Asigna en una variable el producto que del request
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " + id )); //Devuelve error en caso de no encontrar el ID

        productoRepository.delete(producto); //Elimina el producto de la base de datos.
        return "El producto con el ID: " + id + " fue eliminado exitosamente"; //Retorna mensaje de afirmacion ante la eliminacion
    }

}

