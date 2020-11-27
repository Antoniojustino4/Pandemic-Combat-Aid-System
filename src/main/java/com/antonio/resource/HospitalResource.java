package com.antonio.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.antonio.repository.HospitalRepository;
import com.antonio.model.Hospital;


@RestController
@RequestMapping("/hospital")
public class HospitalResource {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	/**
	 * Método que lista de todos os hospitais cadastrados
	 * @return List<Hospital> - Lista de hospitais
	 */
	@GetMapping
	public ResponseEntity<List<Hospital>> listar(){
		List<Hospital> hospitals = hospitalRepository.findAll();
		return hospitals.size() != 0 ? ResponseEntity.ok(hospitals) : ResponseEntity.noContent().build();
	}
	
	
	/**
	 * Método responsável por adicionar novos hospitais ao sistema
	 * 
	 * @param hospital- Objeto que será salvo
	 * @param response- Objeto usado acessar o HTTP de resposta
	 * @return ResponseEntity<Hospital>- Retorna um HTTP com o objeto que adicionado
	 */
	@PostMapping
	public ResponseEntity<Hospital> adicionarHospital(@RequestBody Hospital hospital, HttpServletResponse response) {
		Hospital hospitalSalvo= hospitalRepository.save(hospital);
		
		URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(hospitalSalvo.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return hospitalSalvo.getId() != null ?ResponseEntity.created(uri).body(hospitalSalvo) : ResponseEntity.badRequest().build();
	}
	
	/**
	 * Método responsável por buscar um hospital pelo ID de parâmetro.
	 * 
	 * @param id- ID do hospital
	 * @return ResponseEntity<Hospital>- Retorna um HTTP com o objeto procurado
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<Hospital> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Hospital> optional = hospitalRepository.findById(id);
		return optional.isPresent() ? ResponseEntity.ok(optional.get()): ResponseEntity.notFound().build();
	}
	
	@PutMapping("/atualizarOcupacao/{id}")
	public ResponseEntity<Hospital> atualizarPercentualDeOcupacaoDoHospital(@RequestBody int percentualDeOcupacao,@PathVariable Long id) {
		Optional<Hospital> optional = hospitalRepository.findById(id);
		
		if(optional.isPresent()) {
			Hospital hospital = optional.get();
			hospital.setOcupacao(percentualDeOcupacao);
			hospitalRepository.save(hospital);
			return ResponseEntity.ok(hospital);
		}
		
		return ResponseEntity.notFound().build();
	}

	
	

}
