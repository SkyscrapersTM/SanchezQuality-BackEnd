package com.sanchezquality.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchezquality.security.entity.Usuario;
import com.sanchezquality.security.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repo;
	
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
		return repo.findByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByNombreUsuario(String nombreUsuario) {
		return repo.existsByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByEmail(String email) {
		return repo.existsByEmail(email);
	}

	public void save(Usuario usuario) {
		repo.save(usuario);
	}
}
