package com.sanchezquality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanchezquality.entity.Marca;
import com.sanchezquality.service.MarcaService;

@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "*")
public class MarcaController {
	@Autowired
	MarcaService marcaService;

	@GetMapping("/list")
	public ResponseEntity<List<Marca>> list() {
		List<Marca> list = marcaService.findAll();
		return new ResponseEntity<List<Marca>>(list, HttpStatus.OK);
	}
}