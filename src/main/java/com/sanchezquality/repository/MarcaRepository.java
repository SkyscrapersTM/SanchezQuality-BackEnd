package com.sanchezquality.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanchezquality.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{
	
}