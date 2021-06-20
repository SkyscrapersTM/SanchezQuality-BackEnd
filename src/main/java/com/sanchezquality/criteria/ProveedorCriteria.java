package com.sanchezquality.criteria;

import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

public class ProveedorCriteria {
	private StringFilter pais;
	private StringFilter marca;
	private IntegerFilter dni;
	private StringFilter nombres;
	private StringFilter apellidos;
	private StringFilter razonSocial;
	private StringFilter direccion;
	private StringFilter celular;
	private StringFilter email;
	
	public StringFilter getPais() {
		return pais;
	}
	
	public void setPais(StringFilter pais) {
		this.pais = pais;
	}
	
	public StringFilter getMarca() {
		return marca;
	}
	
	public void setMarca(StringFilter marca) {
		this.marca = marca;
	}
	
	public IntegerFilter getDni() {
		return dni;
	}
	
	public void setDni(IntegerFilter dni) {
		this.dni = dni;
	}
	
	public StringFilter getNombres() {
		return nombres;
	}
	
	public void setNombres(StringFilter nombres) {
		this.nombres = nombres;
	}
	
	public StringFilter getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(StringFilter apellidos) {
		this.apellidos = apellidos;
	}
	
	public StringFilter getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(StringFilter razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public StringFilter getDireccion() {
		return direccion;
	}
	
	public void setDireccion(StringFilter direccion) {
		this.direccion = direccion;
	}
	
	public StringFilter getCelular() {
		return celular;
	}
	
	public void setCelular(StringFilter celular) {
		this.celular = celular;
	}
	
	public StringFilter getEmail() {
		return email;
	}
	
	public void setEmail(StringFilter email) {
		this.email = email;
	}
}