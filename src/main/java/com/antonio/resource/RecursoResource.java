package com.antonio.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonio.model.Recurso;
import com.antonio.repository.RecursoRepository;

@RestController
@RequestMapping("/recurso")
public class RecursoResource {
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Recurso> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Recurso> optional = recursoRepository.findById(id);
		return optional.isPresent() ? ResponseEntity.ok(optional.get()): ResponseEntity.notFound().build();
	}

}
