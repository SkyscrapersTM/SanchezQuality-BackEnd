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

import com.sanchezquality.criteria.ProveedorCriteria;
import com.sanchezquality.dto.BusquedaProveedorDTO;
import com.sanchezquality.dto.Mensaje;
import com.sanchezquality.dto.ProveedorDTO;
import com.sanchezquality.entity.Proveedor;
import com.sanchezquality.service.ProveedorService;

import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

@RestController
@RequestMapping("/proveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorController {
	@Autowired
	ProveedorService proveedorService;

	// Find all + dynamic queries
	@PostMapping("/list")
	public ResponseEntity<Map<String, Object>> list(@RequestBody BusquedaProveedorDTO busquedaDTO) {
		try {
			List<Proveedor> lista = new ArrayList<Proveedor>();
			Pageable paging = PageRequest.of(busquedaDTO.getPage(), busquedaDTO.getSize(),
					Sort.by(busquedaDTO.getOrder()));

			ProveedorCriteria proveedorCriteria = createCriteria(busquedaDTO);

			Page<Proveedor> pageProveedores = proveedorService.findByCriteria(proveedorCriteria, paging);

			if (!busquedaDTO.isAsc()) {
				pageProveedores = proveedorService.findByCriteria(proveedorCriteria, PageRequest.of(busquedaDTO.getPage(),
						busquedaDTO.getSize(), Sort.by(busquedaDTO.getOrder()).descending()));
			}

			lista = pageProveedores.getContent();

			Map<String, Object> response = new HashMap<>();

			response.put("content", lista);
			response.put("currentPage", pageProveedores.getNumber());
			response.put("totalItems", pageProveedores.getTotalElements());
			response.put("totalPages", pageProveedores.getTotalPages());
			response.put("first", pageProveedores.isFirst());
			response.put("last", pageProveedores.isLast());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Proveedor> getById(@PathVariable("id") int id) {
		if (!proveedorService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		}
		Proveedor proveedor = proveedorService.getOne(id).get();
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
	}

	@GetMapping("/detailRazonSocial/{razonSocial}")
	public ResponseEntity<Proveedor> getByRazonSocial(@PathVariable("razonSocial") String razonSocial) {
		if (!proveedorService.existsByRazonSocial(razonSocial)) {
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		}
		Proveedor proveedor = proveedorService.getByRazonSocial(razonSocial).get();
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProveedorDTO proveedorDTO) {
		if (StringUtils.isAllBlank(proveedorDTO.getNombres())) {
			return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getApellidos())) {
			return new ResponseEntity(new Mensaje("Los apellidos son obligatorios."), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getRazonSocial())) {
			return new ResponseEntity(new Mensaje("La razon social es obligatoria."), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getDireccion())) {
			return new ResponseEntity(new Mensaje("La direccion es obligatoria."), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getCelular())) {
			return new ResponseEntity(new Mensaje("El celular es obligatorio."), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getEmail())) {
			return new ResponseEntity(new Mensaje("El email es obligatorio."), HttpStatus.BAD_REQUEST);
		}
		Proveedor proveedor = new Proveedor(proveedorDTO.getDni(), proveedorDTO.getNombres(), proveedorDTO.getApellidos(),
											proveedorDTO.getRazonSocial(), proveedorDTO.getDireccion(), proveedorDTO.getCelular(), 
											proveedorDTO.getEmail(), proveedorDTO.getPais(), proveedorDTO.getMarca());
		proveedorService.save(proveedor);
		return new ResponseEntity(new Mensaje("Proveedor Registrado"), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> create(@PathVariable("id") int id, @RequestBody ProveedorDTO proveedorDTO) {
		if (!proveedorService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getNombres())) {
			return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getApellidos())) {
			return new ResponseEntity(new Mensaje("Los apellidos son obligatorios."), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getRazonSocial())) {
			return new ResponseEntity(new Mensaje("La razon social es obligatoria."), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getDireccion())) {
			return new ResponseEntity(new Mensaje("La direccion es obligatoria."), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getCelular())) {
			return new ResponseEntity(new Mensaje("El celular es obligatorio."), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isAllBlank(proveedorDTO.getEmail())) {
			return new ResponseEntity(new Mensaje("El email es obligatorio."), HttpStatus.BAD_REQUEST);
		}
		
		Proveedor proveedor = proveedorService.getOne(id).get();
		proveedor.setDni(proveedorDTO.getDni());
		proveedor.setNombres(proveedorDTO.getNombres());
		proveedor.setApellidos(proveedorDTO.getApellidos());
		proveedor.setRazonSocial(proveedorDTO.getRazonSocial());
		proveedor.setDireccion(proveedorDTO.getDireccion());
		proveedor.setCelular(proveedorDTO.getCelular());
		proveedor.setEmail(proveedorDTO.getEmail());
		proveedor.setPais(proveedorDTO.getPais());
		proveedor.setMarca(proveedorDTO.getMarca());
		proveedorService.save(proveedor);
		return new ResponseEntity(new Mensaje("Proveedor Actualizado"), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!proveedorService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		proveedorService.delete(id);
		return new ResponseEntity(new Mensaje("Proveedor Eliminado"), HttpStatus.OK);
	}

	private ProveedorCriteria createCriteria(BusquedaProveedorDTO dto) {
		ProveedorCriteria proveedorCriteria = new ProveedorCriteria();
		if (dto != null) {
			if (!StringUtils.isBlank(dto.getPais())) {
				StringFilter filter = new StringFilter();
				filter.setEquals(dto.getPais());
				proveedorCriteria.setPais(filter);
			}
			if (!StringUtils.isBlank(dto.getMarca())) {
				StringFilter filter = new StringFilter();
				filter.setEquals(dto.getMarca());
				proveedorCriteria.setMarca(filter);
			}
			// DNI
			if (!StringUtils.isBlank(dto.getNombres())) {
				StringFilter filter = new StringFilter();
				filter.setContains(dto.getNombres());
				proveedorCriteria.setNombres(filter);
			}
			if (!StringUtils.isBlank(dto.getApellidos())) {
				StringFilter filter = new StringFilter();
				filter.setContains(dto.getApellidos());
				proveedorCriteria.setApellidos(filter);
			}
			if (!StringUtils.isBlank(dto.getRazonSocial())) {
				StringFilter filter = new StringFilter();
				filter.setContains(dto.getRazonSocial());
				proveedorCriteria.setRazonSocial(filter);
			}
			if (!StringUtils.isBlank(dto.getDireccion())) {
				StringFilter filter = new StringFilter();
				filter.setContains(dto.getDireccion());
				proveedorCriteria.setDireccion(filter);
			}
			if (!StringUtils.isBlank(dto.getCelular())) {
				StringFilter filter = new StringFilter();
				filter.setContains(dto.getCelular());
				proveedorCriteria.setCelular(filter);
			}
			if (!StringUtils.isBlank(dto.getEmail())) {
				StringFilter filter = new StringFilter();
				filter.setContains(dto.getEmail());
				proveedorCriteria.setEmail(filter);
			}
		}
		return proveedorCriteria;
	}
}