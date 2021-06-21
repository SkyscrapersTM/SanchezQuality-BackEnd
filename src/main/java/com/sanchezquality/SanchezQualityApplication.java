package com.sanchezquality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sanchezquality.entity.Pais;
import com.sanchezquality.repository.PaisRepository;
import com.sanchezquality.service.PaisService;

@SpringBootApplication
public class SanchezQualityApplication implements CommandLineRunner{
	@Autowired
	PaisRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SanchezQualityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
