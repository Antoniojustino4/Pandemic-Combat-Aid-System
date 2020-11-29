package com.antonio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonio.model.Hospital;
import com.antonio.service.RelatorioService;

/**Classe que rebece as requisições HTTP, referente aos relatórios"
 * 
 * @author anton
 *
 */
@RestController
@RequestMapping("/relatorio")
public class RelatorioResource {
	
	/**Variável responsável por estabelecer a conexão com os objetos Repository
	 */
	@Autowired
	private RelatorioService relatorioService;
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação acima de 90%
	 * 
	 * @return ResponseEntity<List<Hospital>>- Retorna um objeto HTTP com uma lista de hospitais com índice de ocupação acima de 90%
	 */
	@GetMapping("/hospitaisComMaisDe90DeOcupacao")
	public ResponseEntity<List<Hospital>> hospitaisComMaisDe90DeOcupacao() {
		return ResponseEntity.ok(relatorioService.hospitaisComMaisDe90DeOcupacao());
	}
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação abaixo de 90%
	 * 
	 * @return ResponseEntity<List<Hospital>>- Retorna um objeto HTTP com uma lista de hospitais com índice de ocupação abaixo de 90%
	 */
	@GetMapping("/hospitaisComMenosDe90DeOcupacao")
	public ResponseEntity<List<Hospital>> hospitaisComMenosrDe90DeOcupacao() {
		return ResponseEntity.ok(relatorioService.hospitaisComMenosDe90DeOcupacao());
	}
	
	/**Método responsável por emitir um relatório com a média de recursos por hospital
	 * 
	 * @return ResponseEntity<List<Object>>- Retorna um objeto HTTP com uma médio de recursos por hospital
	 */
	@GetMapping("/mediaDeRecursosPorHospital")
	public ResponseEntity<List<Object>> mediaDeRecursosPorHospital() {
		return ResponseEntity.ok(relatorioService.mediaDeRecursosPorHospital());
	}
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação acima de 90% por ordem de tempo(os mais antigos para os mais recentes)
	 * 
	 * @return ResponseEntity<List<Hospital>>- Retorna um objeto HTTP, com a lista de hospitais com índice de ocupação acima de 90% por mais tempo
	 */
	@GetMapping("/superLotacao")
	public ResponseEntity<List<Hospital>> superLotacao(){
		return ResponseEntity.ok(relatorioService.superLotacao());
	}
	
	/**Método responsável por emitir um relatório com os hospitais com índice de ocupação abaixo de 90% por ordem de tempo(os mais antigos para os mais recentes)
	 * 
	 * @return ResponseEntity<List<Hospital>>- Retorna um objeto HTTP, com a lista de hospitais com índice de ocupação abaixo de 90% por mais tempo
	 */
	@GetMapping("/abaixoDaSuperLotacao")
	public ResponseEntity<List<Hospital>> abaixoDaSuperLotacao(){
		return ResponseEntity.ok(relatorioService.abaixoDaSuperLotacao());
	}


}
