package com.sanchezquality.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sanchezquality.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>,JpaSpecificationExecutor<Proveedor>{
	Optional<Proveedor> findByRazonSocial(String razonSocial);
	boolean existsByRazonSocial(String razonSocial);
}