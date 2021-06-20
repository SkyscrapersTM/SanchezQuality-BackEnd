package com.sanchezquality.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int dni;
	
	private String nombres;
	
	private String apellidos;
	
	private String razonSocial;
	
	private String direccion;
	
	private String celular;
	
	private String email;
	
	@ManyToOne(optional = false)
	private Pais pais;
	
	@ManyToOne(optional = false)
	private Marca marca;

	public Proveedor(int dni, String nombres, String apellidos, String razonSocial, String direccion, String celular,
			String email, Pais pais, Marca marca) {
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
	
	public Proveedor() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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