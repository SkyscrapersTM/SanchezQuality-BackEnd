package com.sanchezquality.criteria;

import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

public class ProductoCriteria {

	private StringFilter marca;
	private StringFilter descripcion;
	private IntegerFilter cantidad;
	private DoubleFilter precio;

	public StringFilter getMarca() {
		return marca;
	}

	public void setMarca(StringFilter marca) {
		this.marca = marca;
	}

	public StringFilter getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(StringFilter descripcion) {
		this.descripcion = descripcion;
	}

	public IntegerFilter getCantidad() {
		return cantidad;
	}

	public void setCantidad(IntegerFilter cantidad) {
		this.cantidad = cantidad;
	}

	public DoubleFilter getPrecio() {
		return precio;
	}

	public void setPrecio(DoubleFilter precio) {
		this.precio = precio;
	}

}
