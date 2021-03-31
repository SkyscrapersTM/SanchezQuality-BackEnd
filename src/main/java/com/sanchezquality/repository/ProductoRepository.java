package com.sanchezquality.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sanchezquality.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>,JpaSpecificationExecutor<Producto>{

	Optional<Producto> findByDescripcion(String descripcion);
	boolean existsByDescripcion(String descripcion);
}
