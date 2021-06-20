package com.sanchezquality.security.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchezquality.security.entity.Rol;
import com.sanchezquality.security.enums.RolNombre;
import com.sanchezquality.security.repository.RolRepository;


@Service
@Transactional
public class RolService {

	@Autowired
	RolRepository repo;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return repo.findByRolNombre(rolNombre);
	}
	
	public void save(Rol rol) {
		repo.save(rol);
	}
}
