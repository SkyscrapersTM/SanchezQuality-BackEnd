package com.sanchezquality.dto;

import javax.validation.constraints.NotBlank;

import com.sanchezquality.entity.Marca;
import com.sanchezquality.entity.Pais;

public class ProveedorDTO {
	private int dni;
	
	@NotBlank
	private String nombres;
	
	@NotBlank
	private String apellidos;
	
	@NotBlank
	private String razonSocial;
	
	@NotBlank
	private String direccion;
	
	@NotBlank
	private String celular;
	
	@NotBlank
	private String email;
	
	private Pais pais;
	private Marca marca;

	public ProveedorDTO(int dni, String nombres, String apellidos, String razonSocial, String direccion, String celular, String email,
						Pais pais, Marca marca) {
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.celular = celular;
		this.email = email;
		this.pais = pais;
		this.marca = marca;
	}

	public ProveedorDTO() {
		
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
}