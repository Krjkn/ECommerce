package com.ecommerce.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.producto.entities.Productos;

public interface ProductoRepository extends JpaRepository<Productos, Long> {

}
