package com.antonio.resource;

import java.net.URI;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.antonio.service.HospitalService;

import com.antonio.model.Hospital;

/**Classe que rebece as requisições HTTP, referente ao hospital"
 * 
 * @author anton
 *
 */

@RestController
@RequestMapping("/hospital")
public class HospitalResource {
	
	/**Variável responsável por estabelecer a conexão com os objetos Repository
	 */
	@Autowired
	private HospitalService hospitalService;
	
	/**Método responsável por adicionar novos hospitais ao sistema
	 * 
	 * @param hospital Hospital- Hospital que será salvo
	 * @param response HttpServletResponse- Objeto usado acessar o HTTP de resposta
	 * @return ResponseEntity<Hospital>- Retorna um HTTP com o Hospital que adicionado
	 */
	@PostMapping
	public ResponseEntity<Hospital> adicionarHospital(@RequestBody Hospital hospital, HttpServletResponse response) {
		Hospital hospitalSalvo= hospitalService.save(hospital);
		
		URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(hospitalSalvo.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return hospitalSalvo.getId() != null ?ResponseEntity.created(uri).body(hospitalSalvo) : ResponseEntity.badRequest().build();
	}
	
	/**Método responsável por buscar um hospital pelo ID de parâmetro.
	 * 
	 * @param id Long- ID do hospital
	 * @return ResponseEntity<Hospital>- Retorna um HTTP com o objeto procurado
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<Hospital> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Hospital> optional = hospitalService.findById(id);
		return optional.isPresent() ? ResponseEntity.ok(optional.get()): ResponseEntity.notFound().build();
	}
	
	/**Método utilizado para atualizar o nível de ocupação dos hospitais 
	 * @param ocupacao int- a variável com o novo percentual de ocupação do Hospital
	 * @param id Long- o id do hospital que terá seu percentual atualizado
	 * @return
	 */
	@PutMapping("/atualizarOcupacao/{id}")
	public ResponseEntity<Hospital> atualizarOcupacaoDoHospital(@RequestBody int ocupacao,@PathVariable Long id) {
		Hospital hospital = hospitalService.atualizarOcupacaoDoHospital(ocupacao, id);
		return hospital != null ? ResponseEntity.ok().build() :ResponseEntity.notFound().build();
	}
}
