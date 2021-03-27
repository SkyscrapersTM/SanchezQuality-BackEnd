package com.sanchezquality.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanchezquality.criteria.ProductoCriteria;
import com.sanchezquality.dto.BusquedadProductoDTO;
import com.sanchezquality.entity.Producto;
import com.sanchezquality.service.ProductoService;

import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@PostMapping("/list")
	public ResponseEntity<List<Producto>> list(@RequestBody BusquedadProductoDTO busquedadProductoDTO){
		ProductoCriteria productoCriteria = createCriteria(busquedadProductoDTO);
		List<Producto> list = productoService.findByCriteria(productoCriteria);
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK) ;
	}
	
	private ProductoCriteria createCriteria(BusquedadProductoDTO dto) {
		ProductoCriteria productoCriteria = new ProductoCriteria();
		if(dto!=null) {
			if(!StringUtils.isBlank(dto.getMarca())) {
				StringFilter filter = new StringFilter();
				filter.setEquals(dto.getMarca());
				productoCriteria.setMarca(filter);
			}
			if(!StringUtils.isBlank(dto.getDescripcion())) {
				StringFilter filter = new StringFilter();
				filter.setContains(dto.getDescripcion());
				productoCriteria.setDescripcion(filter);
			}
			if(dto.getCantidadDesde()!=null || dto.getCantidadHasta()!=null) {
				IntegerFilter filter = new IntegerFilter();
				if(dto.getCantidadDesde()!=null) {
					filter.setGreaterThanOrEqual(dto.getCantidadDesde());
					productoCriteria.setCantidad(filter);
				}
				if(dto.getCantidadHasta()!=null) {
					filter.setLessThanOrEqual(dto.getCantidadHasta());
					productoCriteria.setCantidad(filter);
				}
			}
			if(dto.getPrecioDesde()!=null || dto.getPrecioHasta()!=null) {
				DoubleFilter filter = new DoubleFilter();
				if(dto.getPrecioDesde()!=null) {
					filter.setGreaterThanOrEqual(dto.getPrecioDesde());
					productoCriteria.setPrecio(filter);
				}
				if(dto.getPrecioHasta()!=null) {
					filter.setLessThanOrEqual(dto.getPrecioHasta());
					productoCriteria.setPrecio(filter);
				}
			}
		}
		return productoCriteria;
	}
}
