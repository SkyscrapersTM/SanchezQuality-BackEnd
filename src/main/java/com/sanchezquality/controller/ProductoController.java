package com.sanchezquality.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanchezquality.criteria.ProductoCriteria;
import com.sanchezquality.dto.BusquedadProductoDTO;
import com.sanchezquality.dto.Mensaje;
import com.sanchezquality.dto.ProductoDTO;
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

	// Find all + dynamic queries
	@PostMapping("/list")
	public ResponseEntity<Map<String, Object>> list(@RequestBody BusquedadProductoDTO busquedaDTO) {
		try {
			List<Producto> coches = new ArrayList<Producto>();
			Pageable paging = PageRequest.of(busquedaDTO.getPage(), busquedaDTO.getSize(),
					Sort.by(busquedaDTO.getOrder()));

			ProductoCriteria productoCriteria = createCriteria(busquedaDTO);

			Page<Producto> pageProductos = productoService.findByCriteria(productoCriteria, paging);

			if (!busquedaDTO.isAsc()) {
				pageProductos = productoService.findByCriteria(productoCriteria, PageRequest.of(busquedaDTO.getPage(),
						busquedaDTO.getSize(), Sort.by(busquedaDTO.getOrder()).descending()));
			}

			coches = pageProductos.getContent();

			Map<String, Object> response = new HashMap<>();

			response.put("content", coches);
			response.put("currentPage", pageProductos.getNumber());
			response.put("totalItems", pageProductos.getTotalElements());
			response.put("totalPages", pageProductos.getTotalPages());
			response.put("first", pageProductos.isFirst());
			response.put("last", pageProductos.isLast());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Producto> getById(@PathVariable("id") int id) {
		if (!productoService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		}
		Producto producto = productoService.getOne(id).get();
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	@GetMapping("/detaildescripcion/{descripcion}")
	public ResponseEntity<Producto> getByDescripcion(@PathVariable("descripcion") String descripcion) {
		if (!productoService.existsByDescripcion(descripcion)) {
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		}
		Producto producto = productoService.getByDescripcion(descripcion).get();
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProductoDTO productoDTO) {
		if (StringUtils.isAllBlank(productoDTO.getDescripcion())) {
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}
		if (productoDTO.getPrecio() < 0 || productoDTO.getPrecio() == null) {
            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
		}
		Producto producto = new Producto(productoDTO.getDescripcion(), productoDTO.getCantidad(),
				productoDTO.getPrecio(), productoDTO.getMarca());
		productoService.save(producto);
		return new ResponseEntity(new Mensaje("Producto creado!"), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> create(@PathVariable("id") int id, @RequestBody ProductoDTO productoDTO) {
		if (!productoService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		}
		if (StringUtils.isAllBlank(productoDTO.getDescripcion())) {
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}
		if (productoDTO.getPrecio() == null || productoDTO.getPrecio() < 0) {
			return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
		}
		Producto producto = productoService.getOne(id).get();
		producto.setDescripcion(productoDTO.getDescripcion());
		producto.setCantidad(productoDTO.getCantidad());
		producto.setPrecio(productoDTO.getPrecio());
		producto.setMarca(productoDTO.getMarca());
		productoService.save(producto);
		return new ResponseEntity(new Mensaje("Producto actualizado!"), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!productoService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		productoService.delete(id);
		return new ResponseEntity(new Mensaje("Producto eliminado!"), HttpStatus.OK);
	}

	private ProductoCriteria createCriteria(BusquedadProductoDTO dto) {
		ProductoCriteria productoCriteria = new ProductoCriteria();
		if (dto != null) {
			if (!StringUtils.isBlank(dto.getMarca())) {
				StringFilter filter = new StringFilter();
				filter.setEquals(dto.getMarca());
				productoCriteria.setMarca(filter);
			}
			if (!StringUtils.isBlank(dto.getDescripcion())) {
				StringFilter filter = new StringFilter();
				filter.setContains(dto.getDescripcion());
				productoCriteria.setDescripcion(filter);
			}
			if (dto.getCantidadDesde() != null || dto.getCantidadHasta() != null) {
				IntegerFilter filter = new IntegerFilter();
				if (dto.getCantidadDesde() != null) {
					filter.setGreaterThanOrEqual(dto.getCantidadDesde());
					productoCriteria.setCantidad(filter);
				}
				if (dto.getCantidadHasta() != null) {
					filter.setLessThanOrEqual(dto.getCantidadHasta());
					productoCriteria.setCantidad(filter);
				}
			}
			if (dto.getPrecioDesde() != null || dto.getPrecioHasta() != null) {
				DoubleFilter filter = new DoubleFilter();
				if (dto.getPrecioDesde() != null) {
					filter.setGreaterThanOrEqual(dto.getPrecioDesde());
					productoCriteria.setPrecio(filter);
				}
				if (dto.getPrecioHasta() != null) {
					filter.setLessThanOrEqual(dto.getPrecioHasta());
					productoCriteria.setPrecio(filter);
				}
			}
		}
		return productoCriteria;
	}
}
