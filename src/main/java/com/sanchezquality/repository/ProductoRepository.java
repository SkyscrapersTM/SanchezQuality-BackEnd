package com.sanchezquality.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sanchezquality.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>,JpaSpecificationExecutor<Producto>{

}
