package com.sanchezquality.dto;

public class BusquedadProductoDTO {

	private String marca;
	private String descripcion;
	private Integer cantidadDesde;
	private Integer cantidadHasta;
	private Double precioDesde;
	private Double precioHasta;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidadDesde() {
		return cantidadDesde;
	}

	public void setCantidadDesde(Integer cantidadDesde) {
		this.cantidadDesde = cantidadDesde;
	}

	public Integer getCantidadHasta() {
		return cantidadHasta;
	}

	public void setCantidadHasta(Integer cantidadHasta) {
		this.cantidadHasta = cantidadHasta;
	}

	public Double getPrecioDesde() {
		return precioDesde;
	}

	public void setPrecioDesde(Double precioDesde) {
		this.precioDesde = precioDesde;
	}

	public Double getPrecioHasta() {
		return precioHasta;
	}

	public void setPrecioHasta(Double precioHasta) {
		this.precioHasta = precioHasta;
	}

}
