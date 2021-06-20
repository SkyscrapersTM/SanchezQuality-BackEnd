package com.sanchezquality.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchezquality.criteria.ProveedorCriteria;
import com.sanchezquality.entity.Marca_;
import com.sanchezquality.entity.Pais_;
import com.sanchezquality.entity.Proveedor;
import com.sanchezquality.entity.Proveedor_;
import com.sanchezquality.repository.ProveedorRepository;

import io.github.jhipster.service.QueryService;

@Service
@Transactional
public class ProveedorService extends QueryService<Proveedor> {
	@Autowired
	ProveedorRepository proveedorRepository;

	public Optional<Proveedor> getOne(int id) {
		return proveedorRepository.findById(id);
	}

	public Optional<Proveedor> getByRazonSocial(String razonSocial) {
		return proveedorRepository.findByRazonSocial(razonSocial);
	}

	public void save(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}

	public void delete(int id) {
		proveedorRepository.deleteById(id);
	}

	public boolean existsById(int id) {
		return proveedorRepository.existsById(id);
	}

	public boolean existsByRazonSocial(String razonSocial) {
		return proveedorRepository.existsByRazonSocial(razonSocial);
	}

	// Find all + dynamic queries
	public Page<Proveedor> findByCriteria(ProveedorCriteria proveedorCriteria, Pageable pageable) {
		final Specification<Proveedor> specification = createSpecification(proveedorCriteria);
		Page<Proveedor> proveedores = proveedorRepository.findAll(specification, pageable);
		return proveedores;
	}

	private Specification<Proveedor> createSpecification(ProveedorCriteria criteria) {
		Specification<Proveedor> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getDni() != null) {
				specification = specification.and(buildRangeSpecification(criteria.getDni(), Proveedor_.dni));
			}
			if (criteria.getNombres() != null) {
				specification = specification.and(buildStringSpecification(criteria.getNombres(), Proveedor_.nombres));
			}
			if (criteria.getApellidos() != null) {
				specification = specification.and(buildStringSpecification(criteria.getApellidos(), Proveedor_.apellidos));
			}
			if (criteria.getRazonSocial() != null) {
				specification = specification.and(buildStringSpecification(criteria.getRazonSocial(), Proveedor_.razonSocial));
			}
			if (criteria.getDireccion() != null) {
				specification = specification.and(buildStringSpecification(criteria.getDireccion(), Proveedor_.direccion));
			}
			if (criteria.getCelular() != null) {
				specification = specification.and(buildStringSpecification(criteria.getCelular(), Proveedor_.celular));
			}
			if (criteria.getEmail() != null) {
				specification = specification.and(buildStringSpecification(criteria.getEmail(), Proveedor_.email));
			}
			if (criteria.getPais() != null) {
				specification = specification.and(buildReferringEntitySpecification(criteria.getPais(), Proveedor_.pais, Pais_.nombre));
			}
			if (criteria.getMarca() != null) {
				specification = specification.and(buildReferringEntitySpecification(criteria.getMarca(), Proveedor_.marca, Marca_.nombre));
			}
		}
		return specification;
	}
}