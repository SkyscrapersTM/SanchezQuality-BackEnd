package com.sanchezquality.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchezquality.criteria.ProductoCriteria;
import com.sanchezquality.entity.Marca_;
import com.sanchezquality.entity.Producto;
import com.sanchezquality.entity.Producto_;
import com.sanchezquality.repository.ProductoRepository;

import io.github.jhipster.service.QueryService;

@Service
@Transactional
public class ProductoService extends QueryService<Producto> {

	@Autowired
	ProductoRepository productoRepository;

	public Optional<Producto> getOne(int id) {
		return productoRepository.findById(id);
	}

	public Optional<Producto> getByDescripcion(String descripcion) {
		return productoRepository.findByDescripcion(descripcion);
	}

	public void save(Producto producto) {
		productoRepository.save(producto);
	}

	public void delete(int id) {
		productoRepository.deleteById(id);
	}

	public boolean existsById(int id) {
		return productoRepository.existsById(id);
	}

	public boolean existsByDescripcion(String descripcion) {
		return productoRepository.existsByDescripcion(descripcion);
	}

	// Find all + dynamic queries
	public Page<Producto> findByCriteria(ProductoCriteria productoCriteria, Pageable pageable) {
		final Specification<Producto> specification = createSpecification(productoCriteria);
		Page<Producto> productos = productoRepository.findAll(specification, pageable);
		return productos;
	}

	private Specification<Producto> createSpecification(ProductoCriteria criteria) {
		Specification<Producto> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getDescripcion() != null) {
				specification = specification
						.and(buildStringSpecification(criteria.getDescripcion(), Producto_.descripcion));
			}
			if (criteria.getCantidad() != null) {
				specification = specification.and(buildRangeSpecification(criteria.getCantidad(), Producto_.cantidad));
			}
			if (criteria.getPrecio() != null) {
				specification = specification.and(buildRangeSpecification(criteria.getPrecio(), Producto_.precio));
			}
			if (criteria.getMarca() != null) {
				specification = specification
						.and(buildReferringEntitySpecification(criteria.getMarca(), Producto_.marca, Marca_.nombre));
			}
		}
		return specification;
	}
}
