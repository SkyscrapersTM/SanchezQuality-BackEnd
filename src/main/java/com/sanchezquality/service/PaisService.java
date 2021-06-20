package com.sanchezquality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchezquality.entity.Pais;
import com.sanchezquality.repository.PaisRepository;

@Service
@Transactional(readOnly = true)
public class PaisService {
	@Autowired
	PaisRepository paisRepository;
	
	public List<Pais> findAll(){
		return paisRepository.findAll();
	}
}