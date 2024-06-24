package com.sebasdiaz.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebasdiaz.apirest.apirest.Entities.Producto;
                                                    //Tipo entidad, Tipo de ID
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //Para repositorio se requiere un interface que extiende para trabajar el producto y el tipo de identificador

}

