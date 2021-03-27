package com.sanchezquality.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchezquality.entity.Marca;
import com.sanchezquality.repository.MarcaRepository;

@Service
@Transactional(readOnly = true)
public class MarcaService {

	@Autowired
	MarcaRepository marcaRepository;
	
	public List<Marca> findAll(){
		return marcaRepository.findAll();
	}
}
