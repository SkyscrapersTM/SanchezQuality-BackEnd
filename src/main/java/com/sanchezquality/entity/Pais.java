package com.sanchezquality.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(mappedBy = "pais")
	@JsonIgnore
	private Set<Proveedor> proveedor = new HashSet<>();

	public Pais(String nombre, Set<Proveedor> proveedor) {
		this.nombre = nombre;
		this.proveedor = proveedor;
	}
	
	public Pais() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Proveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(Set<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}
}