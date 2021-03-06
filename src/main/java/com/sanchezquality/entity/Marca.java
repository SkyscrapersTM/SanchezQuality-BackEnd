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
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(mappedBy = "marca")
	@JsonIgnore
	private Set<Producto> producto = new HashSet<>();
	
	@OneToMany(mappedBy = "marca")
	@JsonIgnore
	private Set<Proveedor> proveedor = new HashSet<>();

	public Marca(String nombre, Set<Producto> producto, Set<Proveedor> proveedor) {
		this.nombre = nombre;
		this.producto = producto;
		this.proveedor = proveedor;
	}

	public Marca() {
		
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

	public Set<Producto> getProducto() {
		return producto;
	}

	public void setProducto(Set<Producto> producto) {
		this.producto = producto;
	}
	
	public Set<Proveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(Set<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}
}