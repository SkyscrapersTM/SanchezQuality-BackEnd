package com.sanchezquality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanchezquality.entity.Pais;
import com.sanchezquality.service.PaisService;

@RestController
@RequestMapping("/pais")
@CrossOrigin(origins = "*")
public class PaisController {
	@Autowired
	PaisService paisService;

	@GetMapping("/list")
	public ResponseEntity<List<Pais>> list() {
		List<Pais> list = paisService.findAll();
		return new ResponseEntity<List<Pais>>(list, HttpStatus.OK);
	}
}