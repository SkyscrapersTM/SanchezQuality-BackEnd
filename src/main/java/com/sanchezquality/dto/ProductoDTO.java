package com.sanchezquality.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sanchezquality.entity.Marca;

public class ProductoDTO {

	@NotBlank
	private String descripcion;
	@Min(0)
	private int cantidad;
	@Min(0)
	private Double precio;
	private Marca marca;

	public ProductoDTO(String descripcion, int cantidad, Double precio, Marca marca) {
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.marca = marca;
	}

	public ProductoDTO() {
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
